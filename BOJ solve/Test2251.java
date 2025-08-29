import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test2251 {
    private static List<Integer> answers = new ArrayList<>();
    private static int[] from = { 0, 0, 1, 1, 2, 2 };
    private static int[] to = { 1, 2, 0, 2, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bfs(a, b, c);
        Collections.sort(answers);

        for (int ans : answers)
            sb.append(ans + " ");

        System.out.println(sb);
    }

    private static void bfs(int a, int b, int c) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] check = new boolean[a + 1][b + 1][c + 1];
        int[] base = { a, b, c };

        q.add(new int[] { 0, 0, c });
        check[0][0][c] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (temp[0] == 0)
                answers.add(temp[2]);

            for (int i = 0; i < 6; i++) {
                int[] next = { temp[0], temp[1], temp[2] };
                next[to[i]] += next[from[i]];
                next[from[i]] = 0;
                if (next[to[i]] > base[to[i]]) {
                    next[from[i]] = next[to[i]] - base[to[i]];
                    next[to[i]] = base[to[i]];
                }
                if (!check[next[0]][next[1]][next[2]]) {
                    check[next[0]][next[1]][next[2]] = true;
                    q.add(next);
                }
            }
        }
    }
}
