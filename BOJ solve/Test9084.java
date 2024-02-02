import java.io.*;

public class Test9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] list = new int[n + 1];
            String[] input = br.readLine().split("\\s+");
            for (int i = 1; i <= n; i++)
                list[i] = Integer.parseInt(input[i - 1]);

            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (j - list[i] > 0)
                        dp[j] = dp[j] + dp[j - list[i]];
                    else if (j - list[i] == 0)
                        dp[j]++;
                }
            }

            System.out.println(dp[m]);
        }
    }
}
