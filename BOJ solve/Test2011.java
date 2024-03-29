import java.io.*;

public class Test2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password = br.readLine();
        if (password.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        long[] dp = new long[password.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= password.length(); i++) {
            if (password.charAt(i - 1) == '0') {
                if (password.charAt(i - 2) == '1' || password.charAt(i - 2) == '2')
                    dp[i] = dp[i - 2] % 1000000;
                else
                    break;
            } else {
                int val = Integer.parseInt(password.substring(i - 2, i));
                if (val >= 10 && val <= 26)
                    dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
                else
                    dp[i] = dp[i - 1] % 1000000;
            }
        }

        System.out.println(dp[password.length()] % 1000000);
    }
}