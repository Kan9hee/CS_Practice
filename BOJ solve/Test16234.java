import java.io.*;
import java.util.*;

public class Test16234 {
    static ArrayList<int[]> list;
    static int[][] map;
    static boolean[][] check;
    static int[] xmove = { 1, -1, 0, 0 };
    static int[] ymove = { 0, 0, 1, -1 };
    static int n, l, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        n = Integer.parseInt(input[0]);
        l = Integer.parseInt(input[1]);
        r = Integer.parseInt(input[2]);
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split("\\s+");
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(input[j]);
        }

        int answer = 0;
        while (true) {
            check = new boolean[n][n];
            boolean none = true;

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (!check[i][j]) {
                        int val = bfs(i, j);
                        if (list.size() > 1) {
                            none = false;
                            val /= list.size();
                            for (int[] temp : list)
                                map[temp[0]][temp[1]] = val;
                        }
                    }
            if (none)
                break;
            answer++;
        }

        System.out.println(answer);
    }

    static private int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        list = new ArrayList<>();
        q.add(new int[] { x, y });
        list.add(new int[] { x, y });
        check[x][y] = true;
        int sum = map[x][y];

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + xmove[i];
                int ny = temp[1] + ymove[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    int dif = Math.abs(map[temp[0]][temp[1]] - map[nx][ny]);
                    if (!check[nx][ny] && dif >= l && dif <= r) {
                        list.add(new int[] { nx, ny });
                        q.add(new int[] { nx, ny });
                        check[nx][ny] = true;
                        sum += map[nx][ny];
                    }
                }
            }
        }

        return sum;
    }
}
