import java.io.*;
import java.util.*;

public class Test16236 {
    static int[] xmove = new int[] { 0, -1, 1, 0 };
    static int[] ymove = new int[] { -1, 0, 0, 1 };
    static int[] shark = new int[2];
    static int size = 2, eat = 0, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 9) {
                    shark[0] = i;
                    shark[1] = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            PriorityQueue<int[]> q = new PriorityQueue<>((q1, q2) -> q1[2] != q2[2] ? Integer.compare(q1[2], q2[2])
                    : (q1[0] != q2[0] ? Integer.compare(q1[0], q2[0]) : Integer.compare(q1[1], q2[1])));
            boolean[][] check = new boolean[n][n];
            q.add(new int[] { shark[0], shark[1], 0 });
            check[shark[0]][shark[1]] = true;
            boolean ate = false;

            while (!q.isEmpty()) {
                shark = q.poll();
                if (map[shark[0]][shark[1]] > 0 && map[shark[0]][shark[1]] < size) {
                    map[shark[0]][shark[1]] = 0;
                    eat++;
                    answer += shark[2];
                    ate = true;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int ny = ymove[i] + shark[0];
                    int nx = xmove[i] + shark[1];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (!check[ny][nx] && map[ny][nx] <= size) {
                            q.add(new int[] { ny, nx, shark[2] + 1 });
                            check[ny][nx] = true;
                        }
                    }
                }
            }

            if (!ate)
                break;

            if (size == eat) {
                size++;
                eat = 0;
            }
        }

        System.out.println(answer);
    }
}
