import java.io.*;
import java.util.*;

public class Test11048 {
    static int[] xmove = new int[] { 1, 0 };
    static int[] ymove = new int[] { 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] map = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        boolean[][] check = new boolean[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split("\\s+");
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(input[j]);
        }
        check[0][0] = true;
        dp[0][0] = map[0][0];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < 2; i++) {
                int nx = temp[0] + xmove[i];
                int ny = temp[1] + ymove[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!check[nx][ny]) {
                        check[nx][ny] = true;
                        dp[nx][ny] = dp[temp[0]][temp[1]] + map[nx][ny];
                        q.add(new int[] { nx, ny });
                    } else if (dp[nx][ny] < dp[temp[0]][temp[1]] + map[nx][ny]) {
                        dp[nx][ny] = dp[temp[0]][temp[1]] + map[nx][ny];
                        q.add(new int[] { nx, ny });
                    }
                }
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }
}
