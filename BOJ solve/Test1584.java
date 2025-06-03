import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Test1584 {
    static class Node {
        int x, y, count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[501][501];
        int[][] costMap = new int[501][501];
        for (int[] row : costMap)
            Arrays.fill(row, Integer.MAX_VALUE);
        costMap[0][0] = 0;

        setUp(br, map, 1);
        setUp(br, map, -1);

        int answer = bfs(map, costMap);
        System.out.println(answer);
    }

    static void setUp(BufferedReader br, int[][] map, int zoneType) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++)
                for (int j = Math.min(y1, y2); j <= Math.max(y1, y2); j++)
                    map[i][j] = zoneType;
        }
    }

    static int bfs(int[][] map, int[][] costMap) {
        int[] xMove = new int[] { 1, 0, -1, 0 };
        int[] yMove = new int[] { 0, 1, 0, -1 };

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.count));
        pq.add(new Node(0, 0, 0));
        costMap[0][0] = 0;

        int result = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            if (temp.x == 500 && temp.y == 500) {
                result = Math.min(result, temp.count);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = temp.x + xMove[i];
                int nextY = temp.y + yMove[i];
                if (nextX >= 0 && nextX <= 500 && nextY >= 0 && nextY <= 500) {
                    if (map[nextX][nextY] == -1)
                        continue;
                    int nextCount = temp.count + map[nextX][nextY];
                    if (nextCount < costMap[nextX][nextY]) {
                        costMap[nextX][nextY] = nextCount;
                        pq.add(new Node(nextX, nextY, nextCount));
                    }
                }
            }
        }

        if (costMap[500][500] == Integer.MAX_VALUE)
            return -1;
        return result;
    }
}
