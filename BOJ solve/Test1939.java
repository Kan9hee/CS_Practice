import java.io.*;
import java.util.*;

public class Test1939 {
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static ArrayList<Node> map[];
    static int[] list;
    static final int maximum = 1000000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new int[N + 1];
        map = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            map[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map[from].add(new Node(to, weight));
            map[to].add(new Node(from, weight));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o2.weight - o1.weight));
        pq.offer(new Node(start, maximum));
        list[start] = maximum;
        while (!pq.isEmpty()) {
            int from = pq.peek().to;
            int weight = pq.peek().weight;
            pq.poll();
            if (list[from] > weight)
                continue;

            for (int i = 0; i < map[from].size(); i++) {
                int to = map[from].get(i).to;
                int weightTo = Math.min(weight, map[from].get(i).weight);
                if (weightTo > list[to]) {
                    list[to] = weightTo;
                    pq.offer(new Node(to, weightTo));
                }
            }
        }

        System.out.println(String.valueOf(list[end]));
    }
}
