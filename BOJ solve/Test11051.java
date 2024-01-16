import java.io.*;

public class Test11051 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        dp = new int[n + 1][k + 1];
        System.out.println(bc(n, k));
    }

    private static int bc(int n, int k) {
        if (dp[n][k] > 0)
            return dp[n][k];
        if (n == k || k == 0)
            return dp[n][k] = 1;
        return dp[n][k] = (bc(n - 1, k - 1) + bc(n - 1, k)) % 10007;
    }
}
