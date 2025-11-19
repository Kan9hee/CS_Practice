package SWEA.D4;

import java.io.*;
import java.util.*;

public class Test3752 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;

            for (int val : arr)
                for (int current = sum; current >= 0; current--)
                    if (dp[current])
                        dp[current + val] = true;

            int result = 0;
            for (boolean d : dp)
                if (d)
                    result++;
            sb.append(result);

            System.out.println(sb.toString());
        }

        br.close();
    }
}
