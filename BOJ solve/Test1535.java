import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][101];
        int[] hpCases = new int[n + 1];
        int[] happyCases = new int[n + 1];

        StringTokenizer hpSt = new StringTokenizer(br.readLine());
        StringTokenizer happySt = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            hpCases[i] = Integer.parseInt(hpSt.nextToken());
            happyCases[i] = Integer.parseInt(happySt.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 100; j++) {
                if (j > hpCases[i])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - hpCases[i]] + happyCases[i]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        System.out.println(dp[n][100]);
    }
}
