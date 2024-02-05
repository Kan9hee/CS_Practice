import java.io.*;
import java.util.*;

public class Test7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] bytes = new int[n];
        int[] costs = new int[n];
        int[] dp = new int[10001]; // (n최댓값 100)*(cost최대크기 100)+1
        Arrays.fill(dp, -1);

        input = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++)
            bytes[i] = Integer.parseInt(input[i]);

        input = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++)
            costs[i] = Integer.parseInt(input[i]);

        for (int i = 0; i < n; i++) {
            int tempCost = costs[i];
            for (int j = 10000; j >= tempCost; j--) {
                if (dp[j - tempCost] != -1)
                    if (dp[j - tempCost] + bytes[i] > dp[j])
                        dp[j] = dp[j - tempCost] + bytes[i];
            }
            if (dp[tempCost] < bytes[i])
                dp[tempCost] = bytes[i];
        }

        for (int i = 0; i <= 10000; i++)
            if (dp[i] >= m) {
                System.out.println(i);
                break;
            }
    }
}
