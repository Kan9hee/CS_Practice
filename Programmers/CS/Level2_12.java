package CS;

import java.util.*;

public class Level2_12 {
    public static void main(String[] args) {
        int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 } };
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int[] xmove = { 1, 0, -1, 0 };
        int[] ymove = { 0, 1, 0, -1 };
        int answer = -1;
        int xend = maps[0].length;
        int yend = maps.length;

        boolean[][] check = new boolean[yend][xend];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 1 }); // y,x,val
        check[0][0] = true;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (temp[0] == yend - 1 && temp[1] == xend - 1) {
                answer = temp[2];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny = temp[0] + ymove[i];
                int nx = temp[1] + xmove[i];
                if (nx >= 0 && ny >= 0 && nx < xend && ny < yend && !check[ny][nx] && maps[ny][nx] == 1) {
                    check[ny][nx] = true;
                    q.add(new int[] { ny, nx, temp[2] + 1 });
                }
            }
        }

        return answer;
    }
}
