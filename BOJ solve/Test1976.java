import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test1976 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String args[]) throws IOException {
        int n, m;
        int[] plan;
        List<Integer>[] map;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        plan = new int[m];
        map = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++)
            map[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1 || i == j)
                    map[i].add(j);
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            plan[i] = Integer.parseInt(st.nextToken());

        String result = solve(n, m, map, plan);
        System.out.println(result);
    }

    public static String solve(int n, int m, List<Integer>[] map, int[] plan) {
        for (int i = 0; i < m - 1; i++) {
            int city1 = plan[i], city2 = plan[i + 1];
            if (!bfs(n, map, city1, city2))
                return "NO";
        }
        return "YES";
    }

    public static boolean bfs(int n, List<Integer>[] map, int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < map[temp].size(); i++) {
                int next = map[temp].get(i);
                if (next == end)
                    return true;
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        return false;
    }
}
