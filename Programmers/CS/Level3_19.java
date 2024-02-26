package CS;

public class Level3_19 {
    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][] { { 2, 2 } }));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int val = 1000000007;

        int[][] map = new int[m + 1][n + 1];
        map[1][1] = 1;
        for (int[] puddle : puddles)
            map[puddle[0]][puddle[1]] = -1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }
                if (i != 1)
                    map[i][j] += map[i - 1][j] % val;
                if (j != 1)
                    map[i][j] += map[i][j - 1] % val;
            }
        }

        return map[m][n] % val;
    }
}
