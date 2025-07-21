package CS;

import java.util.LinkedList;
import java.util.Queue;

public class level2_17 {
    public static void main(String[] args) {
        int[][] land = { { 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 0, 0 },
                { 1, 1, 0, 0, 0, 1, 1, 0 },
                { 1, 1, 1, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 0, 0, 1, 1 } };
        System.out.println(solution(land));
    }

    private static class DrillingResult {
        int minCol, maxCol, oil;

        public DrillingResult(int minCol, int maxCol, int oil) {
            this.minCol = minCol;
            this.maxCol = maxCol;
            this.oil = oil;
        }
    }

    static boolean[][] history;
    static int[] xMove = { 1, 0, 0, -1 };
    static int[] yMove = { 0, 1, -1, 0 };
    static int n, m;

    public static int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        history = new boolean[n][m];

        int[] oilPoints = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 0 || history[i][j])
                    continue;
                DrillingResult result = BFS(land, new int[] { i, j });
                for (int point = result.minCol; point <= result.maxCol; point++)
                    oilPoints[point] += result.oil;
            }
        }

        int answer = 0;
        for (int oilSize : oilPoints)
            answer = Math.max(oilSize, answer);

        return answer;
    }

    private static DrillingResult BFS(int[][] land, int[] start) {
        int minCol = start[1];
        int maxCol = start[1];
        Queue<int[]> q = new LinkedList<>();
        int oil = 0;

        q.add(start);
        history[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (temp[1] > maxCol)
                maxCol = temp[1];
            else if (temp[1] < minCol)
                minCol = temp[1];
            oil++;

            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + yMove[i];
                int nextX = temp[1] + xMove[i];
                if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m) {
                    if (!history[nextY][nextX] && land[nextY][nextX] == 1) {
                        history[nextY][nextX] = true;
                        q.add(new int[] { nextY, nextX });
                    }
                }
            }
        }

        return new DrillingResult(minCol, maxCol, oil);
    }
}
