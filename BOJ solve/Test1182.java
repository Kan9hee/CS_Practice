import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1182 {
    static int[] values;
    static int N, S, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        values = new int[N];
        answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            values[i] = Integer.parseInt(st.nextToken());

        find(0, 0);
        if (S == 0)
            answer--;
        System.out.println(answer);
    }

    private static void find(int num, int sum) {
        if (num == N) {
            if (sum == S)
                answer++;
            return;
        }

        find(num + 1, sum + values[num]);
        find(num + 1, sum);
    }
}
