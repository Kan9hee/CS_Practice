package CS;

import java.util.LinkedList;
import java.util.Queue;

public class Level2_21 {
    public static void main(String[] args) {
        String[] board = { "...D..R", ".D.G...", "....D.D", "D....D.", "..D...." };
        System.out.println(solution(board));
    }

    private static class Path {
        int x, y, count;

        public Path(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    private static int solution(String[] board) {
        int[] xMove = { 1, 0, 0, -1 };
        int[] yMove = { 0, 1, -1, 0 };
        int answer = -1;
        int n = board.length;
        int m = board[0].length();

        char[][] map = new char[n][m];
        boolean[][] check = new boolean[n][m];
        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        Queue<Path> q = new LinkedList<>();
        q.add(new Path(start[0], start[1], 0));
        check[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            Path temp = q.poll();
            if (map[temp.y][temp.x] == 'G') {
                answer = temp.count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = temp.x;
                int nextY = temp.y;

                while (true) {
                    int nx = nextX + xMove[i];
                    int ny = nextY + yMove[i];

                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || map[ny][nx] == 'D')
                        break;

                    nextX = nx;
                    nextY = ny;
                }

                if (!check[nextY][nextX]) {
                    check[nextY][nextX] = true;
                    q.add(new Path(nextY, nextX, temp.count + 1));
                }
            }
        }

        return answer;
    }
}
