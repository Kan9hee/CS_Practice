import java.io.*;
import java.util.*;

public class Test16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] costs = new int[n + 1];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        String[] input = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++)
            costs[i + 1] = Integer.parseInt(input[i]);

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++)
                dp[i] = Math.min(dp[i], dp[i - j] + costs[j]);

        System.out.println(dp[n]);
    }
}
