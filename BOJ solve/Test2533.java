import java.io.*;
import java.util.*;

public class Test2533 {
    static ArrayList<ArrayList<Integer>> arr;
    static int[][] dp;
    static boolean[] check;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][2];
        check = new boolean[n + 1];

        arr = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            arr.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            arr.get(u).add(v);
            arr.get(v).add(u);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int num) {
        check[num] = true;
        dp[num][0] = 0;
        dp[num][1] = 1;
        for (int next : arr.get(num)) {
            if (!check[next]) {
                dfs(next);
                dp[num][0] += dp[next][1];
                dp[num][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}
