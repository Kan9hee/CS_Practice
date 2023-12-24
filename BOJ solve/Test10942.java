import java.io.*;
import java.util.*;

public class Test10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n + 1];
        boolean[][] dp = new boolean[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            list[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
            if (list[i] == list[i - 1])
                dp[i - 1][i] = true;
        }

        for (int i = 2; i < n; i++)
            for (int j = 1; j <= n - i; j++)
                if (list[j] == list[j + i] && dp[j + 1][j + i - 1])
                    dp[j][j + i] = true;

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            if (dp[left][right])
                sb.append("1\n");
            else
                sb.append("0\n");
        }

        System.out.print(sb);
    }
}