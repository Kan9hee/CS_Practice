import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test2565 {
    static int[][] wires;
    static Integer[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        int line = Integer.parseInt(br.readLine());
        wires = new int[line][2];
        DP = new Integer[line];

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            wires[i][0] = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(wires, (w1, w2) -> w1[0] - w2[0]);

        for (int i = 0; i < line; i++)
            answer = Math.max(serach(i), answer);

        System.out.println(line - answer);
    }

    private static int serach(int place) {
        if (DP[place] == null) {
            DP[place] = 1;
            for (int i = place + 1; i < DP.length; i++)
                if (wires[place][1] < wires[i][1])
                    DP[place] = Math.max((DP[place]), serach(i) + 1);
        }

        return DP[place];
    }
}
