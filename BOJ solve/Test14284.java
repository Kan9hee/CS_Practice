import java.io.*;
import java.util.*;

public class Test14284 {
    static class Node {
        int num, val;

        public Node(int num, int val) {
            this.num = num;
            this.val = val;
        }
    }

    static ArrayList<ArrayList<Node>> map;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            map.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            input = br.readLine().split("\\s+");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int val = Integer.parseInt(input[2]);
            map.get(start).add(new Node(end, val));
            map.get(end).add(new Node(start, val));
        }

        input = br.readLine().split("\\s+");
        int s = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        Dijkstra(s, e);
    }

    private static void Dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2) -> n1.val - n2.val);
        int[] list = new int[n + 1];
        Arrays.fill(list, Integer.MAX_VALUE);
        list[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            for (Node next : map.get(temp.num)) {
                if (list[next.num] > list[temp.num] + next.val) {
                    list[next.num] = list[temp.num] + next.val;
                    pq.add(new Node(next.num, list[next.num]));
                }
            }
        }

        System.out.println(list[end]);
    }
}