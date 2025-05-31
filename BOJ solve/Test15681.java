import java.io.*;
import java.util.*;

public class Test15681 {
    static ArrayList<Integer>[] list;
    static boolean check[];
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        check = new boolean[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        dfs(r);
        for (int i = 0; i < q; i++) {
            int value = Integer.parseInt(br.readLine());
            sb.append(dp[value] + "\n");
        }

        System.out.println(sb);
    }

    static int dfs(int node) {
        if (dp[node] != 0)
            return dp[node];

        check[node] = true;
        int count = 1;

        for (int next : list[node])
            if (!check[next])
                count += dfs(next);

        dp[node] = count;
        return dp[node];
    }
}
