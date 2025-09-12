import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();
        char[] third = br.readLine().toCharArray();

        int[][][] dp = new int[first.length + 1][second.length + 1][third.length + 1];

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                for (int k = 0; k < third.length; k++) {
                    if (first[i] == second[j] && second[j] == third[k])
                        dp[i + 1][j + 1][k + 1] = dp[i][j][k] + 1;
                    else
                        dp[i + 1][j + 1][k + 1] = Math.max(Math.max(dp[i + 1][j + 1][k], dp[i + 1][j][k + 1]),
                                dp[i][j + 1][k + 1]);
                }
            }
        }

        System.out.println(dp[first.length][second.length][third.length]);
    }
}
