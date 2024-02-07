import java.io.*;
import java.util.*;

public class Test2638 {
    static int[][] map, compare;
    static int[] xmove = new int[] { 1, 0, -1, 0 };
    static int[] ymove = new int[] { 0, 1, 0, -1 };
    static int n, m, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        compare = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(compare[i], 0);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> q = new LinkedList<>();
        for (;; answer++) {
            boolean[][] check = new boolean[n][m];
            boolean resumption = false;
            q.add(new int[] { 0, 0 });
            while (!q.isEmpty()) {
                int[] temp = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = temp[0] + xmove[i];
                    int ny = temp[1] + ymove[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        if (!check[nx][ny]) {
                            if (map[nx][ny] == 0) {
                                check[nx][ny] = true;
                                q.add(new int[] { nx, ny });
                            } else {
                                resumption = true;
                                map[nx][ny]++;
                            }
                        }
                    }
                }
            }
            if (!resumption)
                break;
            change();
        }

        System.out.println(answer);
    }

    private static void change() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (map[i][j] >= 3 || map[i][j] == 0)
                    map[i][j] = 0;
                else
                    map[i][j] = 1;
            }
    }
}
