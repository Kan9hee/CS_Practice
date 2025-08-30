import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1303 {
    private static char[][] map;
    private static boolean[][] check;
    private static int[] xMove = { 1, 0, 0, -1 };
    private static int[] yMove = { 0, 1, -1, 0 };
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        check = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++)
                map[i][j] = line.charAt(j);
        }

        int wResult = 0, bResult = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    check[i][j] = true;
                    int val = dfs(map[i][j], i, j);
                    if (map[i][j] == 'W')
                        wResult += Math.pow(val, 2);
                    else
                        bResult += Math.pow(val, 2);
                }
            }
        }

        System.out.println(wResult + " " + bResult);
    }

    private static int dfs(char checkCh, int y, int x) {
        int sum = 1;

        for (int i = 0; i < 4; i++) {
            int nextY = y + yMove[i];
            int nextX = x + xMove[i];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                if (map[nextY][nextX] == checkCh && !check[nextY][nextX]) {
                    check[nextY][nextX] = true;
                    sum += dfs(checkCh, nextY, nextX);
                }
            }
        }

        return sum;
    }
}
