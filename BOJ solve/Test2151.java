import java.io.*;
import java.util.*;

public class Test2151 {
    static class Info {
        int x, y, direction, val;

        public Info(int x, int y, int direction, int val) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.val = val;
        }
    }

    static char[][] map;
    static boolean[][][] check;
    static int[] start = new int[2], end = new int[2];
    static int[] xmove = { 1, 0, -1, 0 };
    static int[] ymove = { 0, 1, 0, -1 };
    static int n, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        check = new boolean[n][n][4];

        for (int i = 0, se = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (temp[j] == '#') {
                    if (se == 0) {
                        start[0] = i;
                        start[1] = j;
                        se++;
                    } else {
                        end[0] = i;
                        end[1] = j;
                    }
                }
                map[i][j] = temp[j];
            }
        }

        PriorityQueue<Info> pq = new PriorityQueue<>((Info i1, Info i2) -> i1.val - i2.val);
        for (int i = 0; i < 4; i++)
            pq.add(new Info(start[0], start[1], i, 0));

        while (!pq.isEmpty()) {
            Info temp = pq.poll();
            if (temp.x == end[0] && temp.y == end[1]) {
                answer = temp.val;
                break;
            }
            check[temp.x][temp.y][temp.direction] = true;
            int nx = xmove[temp.direction] + temp.x;
            int ny = ymove[temp.direction] + temp.y;
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (map[nx][ny] != '*' && !check[nx][ny][temp.direction]) {
                    if (map[nx][ny] == '!') {
                        for (int i = 1; i <= 3; i += 2) {
                            int nd = (temp.direction + i) % 4;
                            pq.add(new Info(nx, ny, nd, temp.val + 1));
                        }
                    }
                    pq.add(new Info(nx, ny, temp.direction, temp.val));
                }
            }
        }

        System.out.println(answer);
    }
}
