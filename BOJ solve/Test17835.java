import java.io.*;
import java.util.*;

public class Test17835 {
    static class Info {
        int goal;
        long c;

        public Info(int goal, long c) {
            this.goal = goal;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Info>[] map = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            map[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[v].add(new Info(u, c));
        }

        HashSet<Integer> starts = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++)
            starts.add(Integer.parseInt(st.nextToken()));

        Info answer = dijkstra(map, n, starts);

        System.out.println(answer.goal + "\n" + answer.c);
    }

    static Info dijkstra(ArrayList<Info>[] map, int n, HashSet<Integer> starts) {
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingLong(info -> info.c));
        long[] dist = new long[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(dist, Long.MAX_VALUE);
        for (int start : starts) {
            dist[start] = 0;
            pq.add(new Info(start, 0));
        }

        while (!pq.isEmpty()) {
            Info temp = pq.poll();
            if (visited[temp.goal])
                continue;
            visited[temp.goal] = true;
            for (Info next : map[temp.goal]) {
                int nextNode = next.goal;
                long nextCost = dist[temp.goal] + next.c;

                if (dist[nextNode] > nextCost) {
                    dist[nextNode] = nextCost;
                    pq.add(new Info(nextNode, nextCost));
                }
            }
        }

        int goal = 0;
        long cost = -1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > cost) {
                cost = dist[i];
                goal = i;
            } else if (dist[i] == cost && i < goal) {
                goal = i;
            }
        }

        return new Info(goal, cost);
    }
}
