import java.io.*;
import java.util.*;

public class Test13460 {
    static class Situation {
        int redX, redY, blueX, blueY, count;

        public Situation(int redX, int redY, int blueX, int blueY, int count) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.count = count;
        }
    }

    static char[][] map;
    static int[] xmove = { 1, -1, 0, 0 };
    static int[] ymove = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        int[] r = new int[2], b = new int[2];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'R') {
                    r = new int[] { i, j };
                    map[i][j] = '.';
                } else if (map[i][j] == 'B') {
                    b = new int[] { i, j };
                    map[i][j] = '.';
                }
            }
        }

        Queue<Situation> q = new LinkedList<>();
        q.add(new Situation(r[0], r[1], b[0], b[1], 0));
        while (!q.isEmpty()) {
            Situation temp = q.poll();
            if (temp.count == 10)
                continue;

            for (int i = 0; i < 4; i++) {
                int rx = temp.redX;
                int ry = temp.redY;
                int bx = temp.blueX;
                int by = temp.blueY;
                boolean redCheck = false;
                boolean blueCheck = false;

                while (true) {
                    int nrx = rx + xmove[i];
                    int nry = ry + ymove[i];
                    if (map[nrx][nry] == '#')
                        break;
                    if (map[nrx][nry] == 'O') {
                        redCheck = true;
                        break;
                    }
                    rx = nrx;
                    ry = nry;
                }
                while (true) {
                    int nbx = bx + xmove[i];
                    int nby = by + ymove[i];
                    if (map[nbx][nby] == '#')
                        break;
                    if (map[nbx][nby] == 'O') {
                        blueCheck = true;
                        break;
                    }
                    bx = nbx;
                    by = nby;
                }

                if (blueCheck)
                    continue;
                else if (redCheck) {
                    System.out.println(temp.count + 1);
                    System.exit(0);
                }

                if (temp.redX == rx && temp.redY == ry && temp.blueX == bx && temp.blueY == by)
                    continue;

                if (rx == bx && ry == by) {
                    if (i == 0) {
                        if (temp.redX < temp.blueX)
                            rx--;
                        else
                            bx--;
                    } else if (i == 1) {
                        if (temp.redX < temp.blueX)
                            bx++;
                        else
                            rx++;
                    } else if (i == 2) {
                        if (temp.redY < temp.blueY)
                            ry--;
                        else
                            by--;
                    } else if (i == 3) {
                        if (temp.redY < temp.blueY)
                            by++;
                        else
                            ry++;
                    }
                }

                q.add(new Situation(rx, ry, bx, by, temp.count + 1));
            }
        }

        System.out.println(-1);
    }
}
