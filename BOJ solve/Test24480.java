import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Test24480 {
    static private List<Integer>[] lines;
    static int[] order;
    static private boolean[] check;
    static private int n, m, count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        lines = new List[n + 1];
        order = new int[n + 1];
        check = new boolean[n + 1];
        for (int i = 1; i <= n; i++)
            lines[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            lines[u].add(v);
            lines[v].add(u);
        }

        for (int i = 1; i <= n; i++)
            Collections.sort(lines[i], Comparator.reverseOrder());

        dfs(r);

        for (int i = 1; i <= n; i++)
            sb.append(order[i] + "\n");

        System.out.println(sb);
    }

    private static void dfs(int current) {
        check[current] = true;
        order[current] = count++;
        for (int next : lines[current]) {
            if (!check[next])
                dfs(next);
        }
    }
}
