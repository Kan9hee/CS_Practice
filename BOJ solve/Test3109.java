import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Test3109 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<String[]> map;
    static int[] move = { -1, 0, 1 };
    static int r, c;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();

        for (int i = 0; i < r; i++)
            map.add(br.readLine().split(""));

        int answer = 0;
        for (int i = 0; i < r; i++)
            answer += dfs(i, 0);

        System.out.println(answer);
    }

    public static int dfs(int row, int col) {
        map.get(row)[col] = "x";

        if (col + 1 == c)
            return 1;

        for (int i = 0; i < move.length; i++) {
            int nextRow = row + move[i];
            if (nextRow >= 0 && nextRow < r && map.get(nextRow)[col + 1].equals("."))
                if (dfs(nextRow, col + 1) == 1)
                    return 1;
        }

        return 0;
    }
}
