import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test4179 {
    static class Node {
        char type;
        int y, x;

        public Node(char type, int y, int x) {
            this.type = type;
            this.y = y;
            this.x = x;
        }
    }

    static int[] moveX = { 1, 0, 0, -1 };
    static int[] moveY = { 0, 1, -1, 0 };
    static Node start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];
        int[][] visitMap = new int[r][c];
        List<Node> fires = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                char ch = temp.charAt(j);
                map[i][j] = ch;
                if (ch == 'J')
                    start = new Node(ch, i, j);
                if (ch == 'F')
                    fires.add(new Node(ch, i, j));
            }
        }

        boolean escapeCheck = false;
        Queue<Node> q = new LinkedList<>(fires);
        q.add(start);
        visitMap[start.y][start.x] = 1;

        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.type == 'J' && (temp.y == r - 1 || temp.x == c - 1 || temp.y == 0 || temp.x == 0)) {
                System.out.println(visitMap[temp.y][temp.x]);
                escapeCheck = true;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = temp.y + moveY[i];
                int nextX = temp.x + moveX[i];
                if (nextY >= 0 && nextY < r && nextX >= 0 && nextX < c) {
                    if (temp.type == 'J' && visitMap[nextY][nextX] == 0 && map[nextY][nextX] == '.') {
                        visitMap[nextY][nextX] = visitMap[temp.y][temp.x] + 1;
                        q.add(new Node(temp.type, nextY, nextX));
                    }
                    if (temp.type == 'F') {
                        if (map[nextY][nextX] != 'F' && map[nextY][nextX] != '#') {
                            map[nextY][nextX] = 'F';
                            q.add(new Node(temp.type, nextY, nextX));
                        }
                    }
                }
            }
        }

        if (!escapeCheck)
            System.out.println("IMPOSSIBLE");
    }
}
