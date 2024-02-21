package CS;

import java.util.*;

public class Level3_17 {
    static int[][] map;
    static char[] dir = { 'd', 'l', 'r', 'u' };
    static int[] xmove = { 1, 0, 0, -1 };
    static int[] ymove = { 0, -1, 1, 0 };
    static StringBuilder sb = new StringBuilder();
    static String answer = null;
    static int ex, ey, tx, ty;

    public static void main(String[] args) {
        System.out.println(solution(3, 4, 2, 3, 3, 1, 5)); // dllrl
    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        map = new int[n][m];
        tx = r;
        ty = c;
        ex = n;
        ey = m;

        int dis = distance(x, y, r, c);
        if ((k - dis) % 2 == 1 || k < dis)
            return "impossible";
        dfs(x, y, 0, k);
        return answer == null ? "impossible" : answer;
    }

    private static int distance(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }

    private static void dfs(int x, int y, int count, int k) {
        if (answer != null)
            return;
        if (count + distance(x, y, tx, ty) > k)
            return;
        if (k == count) {
            answer = sb.toString();
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + xmove[i];
            int ny = y + ymove[i];
            if (nx <= ex && ny <= ey && nx > 0 && ny > 0) {
                sb.append(dir[i]);
                dfs(nx, ny, count + 1, k);
                sb.delete(count, count + 1);
            }

        }
    }
}
