import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[c + 101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            for (int j = customer; j <= c + 100; j++)
                if (dp[j - customer] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - customer] + cost);
        }

        int result = Integer.MAX_VALUE;
        for (int i = c; i <= c + 100; i++)
            result = Math.min(result, dp[i]);

        System.out.println(result);
    }
}
