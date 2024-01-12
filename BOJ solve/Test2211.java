import java.io.*;
import java.util.*;

public class Test2211 {
    static class Node {
        int from, to, val;

        Node(int from, int to, int val) {
            this.from = from;
            this.to = to;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Node>> arr = new ArrayList<>();
        ArrayList<Node> answer = new ArrayList<>();

        String[] input = br.readLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        boolean[] visited = new boolean[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++)
            arr.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            input = br.readLine().split("\\s+");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int val = Integer.parseInt(input[2]);
            arr.get(start).add(new Node(start, end, val));
            arr.get(end).add(new Node(end, start, val));
        }

        for (int i = 1; i <= n; i++)
            dp[i] = Integer.MAX_VALUE;
        PriorityQueue<Node> q = new PriorityQueue<>((Node n1, Node n2) -> n1.val - n2.val);
        q.offer(new Node(1, 1, 0));
        visited[1] = true;
        dp[1] = 0;

        while (!q.isEmpty()) {
            Node vertex = q.poll();

            if (!visited[vertex.to]) {
                visited[vertex.to] = true;
                answer.add(vertex);
            }

            for (Node next : arr.get(vertex.to)) {
                if (dp[next.to] > dp[vertex.to] + next.val) {
                    dp[next.to] = dp[vertex.to] + next.val;
                    q.offer(new Node(next.from, next.to, dp[next.to]));
                }
            }
        }

        System.out.println(answer.size());
        for (Node node : answer)
            System.out.println(node.from + " " + node.to);
    }
}
