import java.io.*;

public class Test17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int val = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int temp = i - j * j;
                val = Math.min(val, dp[temp]);
            }
            dp[i] = val + 1;
        }
        System.out.println(dp[n]);
    }
}
