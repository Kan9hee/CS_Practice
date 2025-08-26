import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test17142 {
    private static class Node {
        int y, x, val;

        public Node(int y, int x, int val) {
            this.y = y;
            this.x = x;
            this.val = val;
        }
    }

    private static int[][] map;
    private static Node[] virusArr;
    private static int[] moveX = { 1, 0, 0, -1 };
    private static int[] moveY = { 0, 1, -1, 0 };
    private static int n, m, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        List<Node> virusList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2)
                    virusList.add(new Node(i, j, 0));
            }
        }

        virusArr = virusList.toArray(new Node[0]);
        answer = Integer.MAX_VALUE;

        dfs(new Node[m], 0, 0);
        if (answer == Integer.MAX_VALUE)
            answer = -1;
        System.out.println(answer);
    }

    private static void dfs(Node[] activates, int depth, int start) {
        if (depth == m) {
            bfs(activates);
            return;
        }

        for (int i = start; i < virusArr.length; i++) {
            activates[depth] = virusArr[i];
            dfs(activates, depth + 1, i + 1);
        }
    }

    private static void bfs(Node[] activates) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] checkMap = new boolean[n][n];
        for (Node node : activates) {
            q.add(node);
            checkMap[node.y][node.x] = true;
        }

        int result = 0;
        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (map[temp.y][temp.x] == 0)
                result = Math.max(result, temp.val);

            for (int i = 0; i < 4; i++) {
                int nextY = temp.y + moveY[i];
                int nextX = temp.x + moveX[i];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                    if (!checkMap[nextY][nextX] && map[nextY][nextX] != 1) {
                        q.add(new Node(nextY, nextX, temp.val + 1));
                        checkMap[nextY][nextX] = true;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (map[i][j] == 0 && !checkMap[i][j])
                    return;

        answer = Math.min(answer, result);
    }
}
