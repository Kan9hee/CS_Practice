import java.io.*;

public class Test11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] list = new int[n + 1];
            int[] sum = new int[n + 1];
            int[][] dp = new int[n + 1][n + 1];

            String[] input = br.readLine().split("\\s+");
            for (int j = 1; j <= n; j++) {
                list[j] = Integer.parseInt(input[j - 1]);
                sum[j] = sum[j - 1] + list[j];
            }

            for (int j = 1; j <= n; j++) {
                for (int fs = 1; fs + j <= n; fs++) {
                    int fe = fs + j;
                    dp[fs][fe] = Integer.MAX_VALUE;
                    for (int temp = fs; temp < fe; temp++)
                        dp[fs][fe] = Math.min(dp[fs][fe], dp[fs][temp] + dp[temp + 1][fe] + sum[fe] - sum[fs - 1]);
                }
            }

            System.out.println(dp[1][n]);
        }
    }
}
