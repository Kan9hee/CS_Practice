import java.io.*;
import java.util.*;

public class Test14940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] start = new int[2];
        int[][] map = new int[n][m];
        int[][] resultMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int land = Integer.parseInt(st.nextToken());
                if (land == 2) {
                    start[0] = i;
                    start[1] = j;
                    map[i][j] = 0;
                } else
                    map[i][j] = land;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int[] xMove = new int[] { 0, 1, 0, -1 };
        int[] yMove = new int[] { 1, 0, -1, 0 };
        q.add(new int[] { start[0], start[1], 0 });
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            resultMap[temp[0]][temp[1]] = temp[2];
            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + yMove[i];
                int nextX = temp[1] + xMove[i];
                int nextCount = temp[2] + 1;
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    if (map[nextY][nextX] == 1) {
                        map[nextY][nextX] = 0;
                        q.add(new int[] { nextY, nextX, nextCount });
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && resultMap[i][j] == 0)
                    resultMap[i][j] = -1;
                sb.append(resultMap[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
