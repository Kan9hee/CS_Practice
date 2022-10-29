import java.io.*;
import java.util.*;

class Test7569 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static class Info {
        int x, y, z;

        Info(int tz, int ty, int tx) {
            x = tx;
            y = ty;
            z = tz;
        }
    }

    static Queue<Info> q = new LinkedList<>();
    static int box[][][], x, y, z, count = -1;
    static int set_X[] = { 1, -1, 0, 0, 0, 0 };
    static int set_Y[] = { 0, 0, 1, -1, 0, 0 };
    static int set_Z[] = { 0, 0, 0, 0, 1, -1 };

    static void check() {
        q.add(new Info(0, 0, 0));
        while (!q.isEmpty()) {
            Info temp = q.remove();
            int tx = temp.x;
            int ty = temp.y;
            int tz = temp.z;
            for (int i = 0; i < 6; i++) {
                int cx = tx + set_X[i];
                int cy = ty + set_Y[i];
                int cz = tz + set_Z[i];

                if (cx >= 0 && cx < x && cy >= 0 && cy < y && cz >= 0 && cz < z)
                    if (box[cz][cy][cx] == 0) {
                        q.add(new Info(cz, cy, cx));
                        box[cz][cy][cx] = box[tz][ty][tx] + 1;
                    }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());
        box = new int[z][y][x];
        int already = 0, nullspace = 0;
        boolean unfinished = false;

        for (int i = 0; i < y * z; i++) {
            st = new StringTokenizer(br.readLine());
            for (int t = 0; t < x; t++) {
                box[(int) (i / y)][i % y][t] = Integer.parseInt(st.nextToken());
                if (box[(int) (i / y)][i % y][t] == 1) {
                    q.add(new Info((int) (i / y), i % y, t));
                    already++;
                } else if (box[(int) (i / y)][i % y][t] == -1)
                    nullspace++;
            }
        }

        check();

        for (int i = 0; i < y * z; i++) {
            for (int t = 0; t < x; t++) {
                if (box[(int) (i / y)][i % y][t] == 0)
                    unfinished = true;
                count = Math.max(count, box[(int) (i / y)][i % y][t]);
            }
        }
        if (unfinished)
            System.out.println(-1);
        else if (x * y * z - nullspace == already)
            System.out.println(0);
        else
            System.out.println(count);
    }
}