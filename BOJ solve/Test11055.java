import java.io.*;
import java.util.*;

public class Test11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int[] dp = new int[n];

        String[] input = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++)
            list[i] = Integer.parseInt(input[i]);

        dp[0] = list[0];
        for (int i = 1; i < n; i++) {
            dp[i] = list[i];
            for (int j = 0; j < i; j++)
                if (list[i] > list[j])
                    dp[i] = Math.max(dp[j] + list[i], dp[i]);
        }

        Arrays.sort(dp);
        System.out.println(dp[n - 1]);
    }
}