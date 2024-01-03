import java.io.*;

public class Test1010 {
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (--t >= 0) {
            String[] input = br.readLine().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            System.out.println(Search(m, n));
        }
    }

    private static int Search(int n, int r) {
        if (dp[n][r] > 0)
            return dp[n][r];
        if (n == r || r == 0)
            return dp[n][r] = 1;
        return dp[n][r] = Search(n - 1, r - 1) + Search(n - 1, r);
    }
}
