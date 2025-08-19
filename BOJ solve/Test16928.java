import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test16928 {
    private static class Node {
        int num, count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> ladder = new HashMap<>();
        Map<Integer, Integer> snake = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        boolean[] check = new boolean[101];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ladder.put(start, end);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            snake.put(start, end);
        }

        q.add(new Node(1, 0));
        check[1] = true;
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.num == 100) {
                System.out.println(temp.count);
                break;
            }
            for (int i = 1; i <= 6; i++) {
                int next = temp.num + i;
                if (ladder.containsKey(next))
                    next = ladder.get(next);
                if (snake.containsKey(next))
                    next = snake.get(next);
                if (next > 100)
                    continue;
                if (!check[next]) {
                    check[next] = true;
                    q.add(new Node(next, temp.count + 1));
                }
            }
        }
    }
}
