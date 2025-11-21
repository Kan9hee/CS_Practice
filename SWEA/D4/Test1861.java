package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test1861 {
    static int[][] map;
    static int[][] countMap;
    static int[] moveX = { 1, 0, 0, -1 };
    static int[] moveY = { 0, 1, -1, 0 };
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");

            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            countMap = new int[N][N];
            result = new int[2];

            for (int i = 0; i < N; i++) {
                Arrays.fill(countMap[i], 1);
                String[] rooms = br.readLine().split(" ");
                for (int j = 0; j < N; j++)
                    map[i][j] = Integer.parseInt(rooms[j]);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int val = dfs(i, j, N);
                    if (val > result[1] || (val == result[1] && map[i][j] < result[0])) {
                        result[0] = map[i][j];
                        result[1] = val;
                    }
                }
            }

            sb.append(result[0]).append(" ").append(result[1]);
            System.out.println(sb.toString());
        }

        br.close();
    }

    private static int dfs(int y, int x, int N) {
        if (countMap[y][x] != 1)
            return countMap[y][x];

        for (int i = 0; i < 4; i++) {
            int nextY = y + moveY[i];
            int nextX = x + moveX[i];
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                if (map[nextY][nextX] == map[y][x] + 1)
                    countMap[y][x] = 1 + dfs(nextY, nextX, N);
            }
        }

        return countMap[y][x];
    }
}
