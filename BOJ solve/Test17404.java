import java.io.*;

public class Test17404 {
    static int[][] map, dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][3];
        dp = new int[n][3];
        int[] list = new int[3];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");
            for (int j = 0; j < 3; j++)
                map[i][j] = Integer.parseInt(input[j]);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    dp[0][j] = map[0][j];
                else
                    dp[0][j] = 1000 * 1000 * +1;
            }

            for (int j = 1; j < n; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + map[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + map[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + map[j][2];
                if (j == n - 1) {
                    if (i == 0)
                        list[i] = Math.min(dp[j][1], dp[j][2]);
                    else if (i == 1)
                        list[i] = Math.min(dp[j][0], dp[j][2]);
                    else
                        list[i] = Math.min(dp[j][0], dp[j][1]);
                }
            }
        }

        System.out.println(Math.min(Math.min(list[0], list[1]), list[2]));
    }
}
