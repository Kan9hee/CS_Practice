import java.io.*;

public class Test2352 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int[] dp = new int[n];
        dp[0] = 1;

        String[] input = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++)
            list[i] = Integer.parseInt(input[i]);

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (list[j] < list[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int answer = 0;
        for (int temp : dp)
            answer = Math.max(answer, temp);

        System.out.println(answer);
    }
}
