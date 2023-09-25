import java.io.*;
import java.util.*;

class Test11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][N + 1];
        int[][] DP = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                DP[i][j] = map[i][j] + DP[i][j - 1] + DP[i - 1][j] - DP[i - 1][j - 1];
            }
        }

        for (int i = 0; i < M; i++) {
            int[] range = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int t = 0; t < 4; t++)
                range[t] = Integer.parseInt(st.nextToken());
            System.out.println(DP[range[2]][range[3]] - DP[range[2]][range[1] - 1] - DP[range[0] - 1][range[3]]
                    + DP[range[0] - 1][range[1] - 1]);
        }
    }
}