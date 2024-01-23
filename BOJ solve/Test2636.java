import java.io.*;
import java.util.*;

public class Test2636 {
    static int[][] map;
    static int[] xmove = new int[] { 1, 0, -1, 0 };
    static int[] ymove = new int[] { 0, 1, 0, -1 };
    static int[] matchExam;
    static int y, x, lastCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        y = Integer.parseInt(input[0]);
        x = Integer.parseInt(input[1]);
        map = new int[y + 2][x + 2];
        matchExam = new int[x + 2];

        for (int i = 1; i <= y; i++) {
            input = br.readLine().split("\\s+");
            for (int j = 1; j <= x; j++)
                map[i][j] = Integer.parseInt(input[j - 1]);
        }

        int answer = 0;
        while (!clearCheck()) {
            lastCount = 0;
            BFS();
            answer++;
        }

        System.out.println(answer + "\n" + lastCount);
    }

    private static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] check = new boolean[y + 2][x + 2];
        q.add(new int[] { 0, 0 });
        check[0][0] = true;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = temp[0] + ymove[i];
                int nx = temp[1] + xmove[i];
                if (nx >= 0 && ny >= 0 && nx <= x + 1 && ny <= y + 1) {
                    if (!check[ny][nx]) {
                        check[ny][nx] = true;
                        if (map[ny][nx] == 0)
                            q.add(new int[] { ny, nx });
                        else {
                            map[ny][nx] = 0;
                            lastCount++;
                        }
                    }
                }
            }
        }
    }

    private static boolean clearCheck() {
        for (int i = 1; i <= y; i++)
            if (!Arrays.equals(map[i], matchExam))
                return false;
        return true;
    }
}
