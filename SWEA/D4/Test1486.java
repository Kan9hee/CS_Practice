package SWEA.D4;

import java.io.*;
import java.util.*;

public class Test1486 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");
            int tower = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] >= B)
                    tower = Math.min(tower, arr[i]);
            }

            Arrays.sort(arr);

            if (tower != B)
                tower = dfs(arr, 0, 0, tower, N, B);

            sb.append(tower - B);
            System.out.println(sb.toString());
        }

        br.close();
    }

    private static int dfs(int[] arr, int currentNum, int sum, int tower, int N, int B) {
        if (sum >= tower)
            return tower;
        if (sum >= B)
            return Math.min(sum, tower);
        if (currentNum == N)
            return tower;

        tower = dfs(arr, currentNum + 1, sum + arr[currentNum], tower, N, B);
        tower = dfs(arr, currentNum + 1, sum, tower, N, B);

        return tower;
    }
}