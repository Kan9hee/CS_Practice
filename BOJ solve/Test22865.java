import java.util.*;
import java.io.*;

public class Test22865 {
    static class Node {
        int place, cost;

        Node(int place, int cost) {
            this.place = place;
            this.cost = cost;
        }
    }

    static ArrayList<Node>[] list;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, cost));
            list[to].add(new Node(from, cost));
        }

        long[] dist1 = dijkstra(a);
        long[] dist2 = dijkstra(b);
        long[] dist3 = dijkstra(c);

        int result = 0;
        long maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            long minDistance = Math.min(dist1[i], Math.min(dist2[i], dist3[i]));
            if (minDistance > maxDistance) {
                maxDistance = minDistance;
                result = i;
            }
        }

        System.out.println(result);
    }

    private static long[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        long[] dist = new long[n + 1];

        for (int i = 1; i <= n; i++)
            dist[i] = Long.MAX_VALUE;
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            if (dist[temp.place] < temp.cost)
                continue;

            for (int i = 0; i < list[temp.place].size(); i++) {
                int nextPlace = list[temp.place].get(i).place;
                int nextCost = temp.cost + list[temp.place].get(i).cost;
                if (dist[nextPlace] > nextCost) {
                    dist[nextPlace] = nextCost;
                    pq.add(new Node(nextPlace, nextCost));
                }
            }
        }

        return dist;
    }
}
