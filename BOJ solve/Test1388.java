import java.io.*;

public class Test1388 {

    static String[][] map;
    static boolean[][] check;
    static int[] move = { 1, -1 };
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new String[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++)
                map[i][j] = input[j];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j]) {
                    dfs(i, j, map[i][j]);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(int y, int x, String basic) {
        check[y][x] = true;
        for (int i = 0, next = 0; i < 2; i++) {
            if (map[y][x].equals("|")) {
                next = y + move[i];
                if (next >= 0 && next < n && map[next][x].equals(basic) && !check[next][x])
                    dfs(next, x, basic);
            } else {
                next = x + move[i];
                if (next >= 0 && next < m && map[y][next].equals(basic) && !check[y][next])
                    dfs(y, next, basic);
            }
        }
    }
}
