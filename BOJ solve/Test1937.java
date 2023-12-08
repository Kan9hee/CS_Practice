import java.io.*;

public class Test1937 {
    static int[][] map;
    static int[][] dp;
    static int[] xmove = { 1, -1, 0, 0 };
    static int[] ymove = { 0, 0, 1, -1 };
    static int n, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(input[j]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                answer = Math.max(answer, dfs(i, j));
        }

        System.out.println(answer);
    }

    private static int dfs(int x, int y) {
        if (dp[x][y] != 0)
            return dp[x][y];
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + xmove[i];
            int ny = y + ymove[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n)
                if (map[x][y] < map[nx][ny])
                    dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
        }
        return dp[x][y];
    }
}
