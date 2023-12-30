import java.io.*;
import java.util.*;

public class Test18223 {
    static class Node {
        int end, val;
        boolean check;

        public Node(int end, int val, boolean check) {
            this.end = end;
            this.val = val;
            this.check = check;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        int p = Integer.parseInt(input[2]);
        ArrayList<Node>[] map = new ArrayList[v + 1];
        int[] dp = new int[v + 1];

        for (int i = 0; i <= v; i++)
            map[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            input = br.readLine().split("\\s+");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int val = Integer.parseInt(input[2]);
            map[start].add(new Node(end, val, false));
            map[end].add(new Node(start, val, false));
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2) -> n1.val - n2.val);
        pq.add(new Node(1, 0, false));
        int endVal = Integer.MAX_VALUE;
        boolean result = false;
        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            if (temp.end == v) {
                if (temp.val > endVal)
                    break;
                if (temp.check) {
                    result = true;
                    break;
                }
                endVal = temp.val;
            }
            if (temp.end == p)
                temp.check = true;
            for (Node next : map[temp.end]) {
                if (dp[next.end] >= dp[temp.end] + next.val) {
                    dp[next.end] = dp[temp.end] + next.val;
                    pq.add(new Node(next.end, dp[next.end], temp.check));
                }
            }
        }

        System.out.println(result ? "SAVE HIM" : "GOOD BYE");
    }
}
