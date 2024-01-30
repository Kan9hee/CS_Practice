import java.io.*;

public class Test2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] line = new int[n];
        int[] dp = new int[n];
        int answer = 0;

        for (int i = 0; i < n; i++)
            line[i] = Integer.parseInt(br.readLine());

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
                if (line[i] > line[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(n - answer);
    }
}
