import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test15684 {
    static int[][] map;
    static int N, M, H, answer;
    static boolean is_finish = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        answer = 0;
        if (M == 0) {
            System.out.println(answer);
            return;
        }

        map = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken());
            map[point][line] = line + 1;
            map[point][line + 1] = line;
        }

        for (int i = 0; i <= 3; i++) {
            answer = i;
            dfs(1, 0);
            if (is_finish)
                break;
        }

        answer = is_finish ? answer : -1;
        System.out.println(answer);
    }

    private static void dfs(int line, int count) {
        if (is_finish)
            return;
        if (answer == count) {
            if (check())
                is_finish = true;
            return;
        }

        for (int i = line; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = j + 1;
                    map[i][j + 1] = j;
                    dfs(i, count + 1);
                    map[i][j] = map[i][j + 1] = 0;
                }
            }
        }
    }

    private static boolean check() {
        for (int i = 1; i <= N; i++) {
            int line = i;
            int depth = 1;
            for (int j = 1; j <= H; j++) {
                if (map[depth][line] != 0)
                    line = map[depth][line];
                depth++;
            }
            if (line != i)
                return false;
        }

        return true;
    }
}
