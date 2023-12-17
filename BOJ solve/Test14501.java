import java.io.*;

public class Test14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[n][2];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");
            int time = Integer.parseInt(input[0]);
            int price = Integer.parseInt(input[1]);
            list[i] = new int[] { time, price };
        }

        for (int i = n - 1; i >= 0; i--) {
            if (list[i][0] + i > n)
                dp[i] = dp[i + 1];
            else
                dp[i] = Math.max(list[i][1] + dp[i + list[i][0]], dp[i + 1]);
        }

        System.out.println(dp[0]);
    }
}
