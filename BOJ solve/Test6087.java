import java.io.*;
import java.util.*;

public class Test6087 {
    static class Node {
        int x, y, count, direction;

        public Node(int x, int y, int count, int direction) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.direction = direction;
        }
    }

    static ArrayList<int[]> position = new ArrayList<>();
    static char[][] map;
    static int[] start = new int[2], end = new int[2];
    static int[] xmove = { 1, 0, -1, 0 };
    static int[] ymove = { 0, 1, 0, -1 };
    static int w, h, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        w = Integer.parseInt(input[0]);
        h = Integer.parseInt(input[1]);
        map = new char[h][w];
        for (int i = 0; i < h; i++) {
            String line = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'C')
                    position.add(new int[] { i, j });
            }
        }
        start[0] = position.get(0)[0];
        start[1] = position.get(0)[1];
        end[0] = position.get(1)[0];
        end[1] = position.get(1)[1];
        map[end[0]][end[1]] = '.';

        Dijkstra();
        System.out.println(answer);
    }

    private static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2) -> n1.count - n2.count);
        int[][][] check = new int[h][w][4];
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                Arrays.fill(check[i][j], 10001);
        pq.add(new Node(start[1], start[0], -1, -1));
        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            if (temp.x == end[1] && temp.y == end[0]) {
                answer = temp.count;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + xmove[i];
                int ny = temp.y + ymove[i];
                if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
                    if (map[ny][nx] == '.') {
                        if (temp.direction != i && check[ny][nx][i] > temp.count + 1) {
                            pq.add(new Node(nx, ny, temp.count + 1, i));
                            check[ny][nx][i] = temp.count + 1;
                        }
                        if (temp.direction == i && check[ny][nx][i] > temp.count) {
                            pq.add(new Node(nx, ny, temp.count, i));
                            check[ny][nx][i] = temp.count;
                        }
                    }
                }
            }
        }
    }
}
