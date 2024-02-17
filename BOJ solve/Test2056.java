import java.io.*;
import java.util.*;

public class Test2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split("\\s+");
            int val = Integer.parseInt(input[0]);
            int count = Integer.parseInt(input[1]);
            dp[i] = val;
            if (count != 0) {
                for (int j = 2; j < input.length; j++) {
                    int link = Integer.parseInt(input[j]);
                    dp[i] = Math.max(dp[i], dp[link] + val);
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[N]);
    }
}
