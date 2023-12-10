import java.io.*;
import java.util.*;

public class Test14497 {
    static String[][] map;
    static boolean[][] check;
    static int[] xmove = { 1, -1, 0, 0 };
    static int[] ymove = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        map = new String[n + 1][m + 1];

        input = br.readLine().split("\\s+");
        int x1 = Integer.parseInt(input[0]);
        int y1 = Integer.parseInt(input[1]);
        int x2 = Integer.parseInt(input[2]);
        int y2 = Integer.parseInt(input[3]);

        for (int i = 1; i <= n; i++) {
            input = br.readLine().split("");
            for (int j = 1; j <= m; j++)
                map[i][j] = input[j - 1];
        }

        int answer = 0;
        for (boolean finish = false; !finish; answer++) {
            Queue<int[]> q = new LinkedList<>();
            check = new boolean[n + 1][m + 1];
            q.add(new int[] { x1, y1 });
            while (!q.isEmpty() && !finish) {
                int[] temp = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = temp[0] + xmove[i];
                    int ny = temp[1] + ymove[i];
                    if (nx > 0 && ny > 0 && nx <= n && ny <= m && !check[nx][ny]) {
                        check[nx][ny] = true;
                        if (map[nx][ny].equals("1"))
                            map[nx][ny] = "0";
                        else if (map[nx][ny].equals("#")) {
                            finish = true;
                            break;
                        } else
                            q.add(new int[] { nx, ny });
                    }
                }
            }
        }

        System.out.println(answer);
    }
}