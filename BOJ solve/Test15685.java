import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Test15685 {
    static boolean[][] map = new boolean[101][101];
    static int[] xMove = { 1, 0, -1, 0 };
    static int[] yMove = { 0, -1, 0, 1 };
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dragonCurve(x, y, d, g);
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1])
                    answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dragonCurve(int x, int y, int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        for (int i = 0; i < g; i++) {
            for (int j = directions.size() - 1; j >= 0; j--)
                directions.add((directions.get(j) + 1) % 4);
        }

        map[y][x] = true;
        for (int dir : directions) {
            x += xMove[dir];
            y += yMove[dir];
            if (x >= 0 && x < 101 && y >= 0 && y < 101)
                map[y][x] = true;
        }
    }
}
