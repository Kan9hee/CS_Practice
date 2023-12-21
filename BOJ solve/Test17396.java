import java.io.*;
import java.util.*;

public class Test17396 {
    static class Node implements Comparable<Node> {
        int end;
        long time;

        public Node(int end, long time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Node n) {
            if (this.time - n.time > 0)
                return 1;
            else
                return -1;
        }
    }

    static ArrayList<Node>[] map;
    static int[] sights;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new ArrayList[n];
        sights = new int[n];

        input = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
            sights[i] = Integer.parseInt(input[i]);
        }
        for (int i = 0; i < m; i++) {
            input = br.readLine().split("\\s+");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            long time = Long.parseLong(input[2]);
            map[start].add(new Node(end, time));
            map[end].add(new Node(start, time));
        }

        Dijkstra();
    }

    private static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long[] list = new long[n];
        boolean[] check = new boolean[n];
        Arrays.fill(list, Long.MAX_VALUE);
        list[0] = 0;
        sights[n - 1] = 0;
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            if (check[temp.end])
                continue;
            check[temp.end] = true;
            for (Node i : map[temp.end]) {
                if (list[i.end] > list[temp.end] + i.time && sights[i.end] != 1) {
                    list[i.end] = list[temp.end] + i.time;
                    pq.add(new Node(i.end, list[i.end]));
                }
            }
        }

        if (list[n - 1] == Long.MAX_VALUE)
            list[n - 1] = -1;
        System.out.println(list[n - 1]);
    }
}