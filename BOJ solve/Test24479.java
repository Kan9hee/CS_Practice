import java.util.*;

public class Test24479 {
    static List<Integer>[] map;
    static int[] resultArray;
    static boolean[] visited;
    static int n, m;
    static int count = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        resultArray = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++)
            map[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(sc.nextLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u].add(v);
            map[v].add(u);
        }

        for (int i = 1; i <= n; i++)
            Collections.sort(map[i]);

        dfs(r);
        for (int i = 1; i <= n; i++)
            sb.append(resultArray[i] + "\n");

        System.out.println(sb);
        sc.close();
    }

    static void dfs(int nodeNum) {
        visited[nodeNum] = true;
        resultArray[nodeNum] = count++;

        for (int next : map[nodeNum]) {
            if (!visited[next])
                dfs(next);
        }
    }
}
