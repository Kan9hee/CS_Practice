import java.io.*;

public class Test11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[n][2];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");
            list[i][0] = Integer.parseInt(input[0]);
            list[i][1] = Integer.parseInt(input[1]);
        }

        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                dp[i][i + gap] = Integer.MAX_VALUE;
                for (int j = i; j < i + gap; j++)
                    dp[i][i + gap] = Math.min(dp[i][i + gap],
                            dp[i][j] + dp[j + 1][i + gap] + list[i][0] * list[j][1] * list[i + gap][1]);
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}
