import java.io.*;
import java.util.*;

public class Test13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int[][] dp = new int[2][n];

        String[] input = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++)
            list[i] = Integer.parseInt(input[i]);

        dp[0][0] = dp[1][0] = list[0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1] + list[i], list[i]);
            dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + list[i]);
        }

        Arrays.sort(dp[0]);
        Arrays.sort(dp[1]);

        System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
    }
}
