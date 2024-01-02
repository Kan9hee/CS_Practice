import java.io.*;
import java.util.*;

public class Test13424 {
    static class Node {
        int end, val;

        public Node(int end, int val) {
            this.end = end;
            this.val = val;
        }
    }

    static ArrayList<Node>[] ways;
    static int[] list, answer;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split("\\s+");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            ways = new ArrayList[n + 1];
            answer = new int[n + 1];

            for (int j = 0; j <= n; j++)
                ways[j] = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                input = br.readLine().split("\\s+");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                int val = Integer.parseInt(input[2]);
                ways[start].add(new Node(end, val));
                ways[end].add(new Node(start, val));
            }

            int k = Integer.parseInt(br.readLine());
            input = br.readLine().split("\\s+");
            for (int j = 0; j < k; j++) {
                int place = Integer.parseInt(input[j]);
                Dijkstra(place);
                for (int q = 1; q <= n; q++)
                    answer[q] += list[q];
            }

            int minSum = Integer.MAX_VALUE;
            int minNum = 0;
            for (int j = 1; j <= n; j++) {
                if (answer[j] < minSum) {
                    minNum = j;
                    minSum = answer[j];
                }
            }

            sb.append(minNum).append("\n");
        }
        System.out.println(sb);
    }

    private static void Dijkstra(int num) {
        PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2) -> n2.val - n1.val);
        boolean[] check = new boolean[n + 1];
        list = new int[n + 1];
        Arrays.fill(list, Integer.MAX_VALUE);
        list[num] = 0;
        pq.add(new Node(num, 0));

        while (!pq.isEmpty()) {
            Node temp = pq.poll();

            if (check[temp.end])
                continue;
            check[temp.end] = true;

            for (Node next : ways[temp.end]) {
                if (list[next.end] > list[temp.end] + next.val) {
                    list[next.end] = list[temp.end] + next.val;
                    pq.add(new Node(next.end, list[next.end]));
                }
            }
        }
    }
}
