import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test10830 {
    final static int MAX = 1000;
    static int N;
    static int[][] base;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        base = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                base[i][j] = Integer.parseInt(st.nextToken()) % MAX;
        }

        int[][] answer = find(base, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                sb.append(answer[i][j]).append(' ');
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static int[][] find(int[][] now, long val) {
        if (val == 1L)
            return now;

        int[][] multi = find(now, val / 2);
        multi = calculate(multi, multi);

        if (val % 2 == 1L)
            multi = calculate(multi, base);

        return multi;
    }

    private static int[][] calculate(int[][] o1, int[][] o2) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += (o1[i][k] * o2[k][j]);
                    result[i][j] %= MAX;
                }
            }
        }

        return result;
    }
}
