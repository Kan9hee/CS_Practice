import java.io.*;
import java.util.*;

public class Test11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int[] dp = new int[n];

        String[] input = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++)
            list[i] = Integer.parseInt(input[i]);

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--)
                if (list[i] < list[j] && dp[i] <= dp[j])
                    dp[i] = dp[j] + 1;
        }

        Arrays.sort(dp);
        System.out.println(dp[n - 1]);
    }
}
