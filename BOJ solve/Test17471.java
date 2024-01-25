import java.io.*;
import java.util.*;

public class Test17471 {
    static boolean[][] map;
    static boolean[] check;
    static int[] list, districts;
    static int n, answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new boolean[n + 1][n + 1];
        list = new int[n + 1];

        String[] input = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++)
            list[i + 1] = Integer.parseInt(input[i]);

        for (int i = 1; i <= n; i++) {
            input = br.readLine().split("\\s+");
            for (int j = 1; j < input.length; j++) {
                int temp = Integer.parseInt(input[j]);
                map[i][temp] = true;
            }
        }

        districts = new int[n + 1];
        dfs(1);

        if (answer == Integer.MAX_VALUE)
            answer = -1;
        System.out.println(answer);
    }

    private static void dfs(int num) {
        if (num > n) {
            int dis1 = 0, dis2 = 0;
            for (int i = 1; i <= n; i++) {
                if (districts[i] == 1)
                    dis1 += list[i];
                else
                    dis2 += list[i];
            }

            check = new boolean[n + 1];
            int linkCount = 0;
            for (int i = 1; i <= n; i++)
                if (!check[i]) {
                    bfs(i, districts[i]);
                    linkCount++;
                }

            if (linkCount == 2)
                answer = Math.min(answer, Math.abs(dis1 - dis2));

            return;
        }

        districts[num] = 1;
        dfs(num + 1);

        districts[num] = -1;
        dfs(num + 1);
    }

    private static void bfs(int idx, int dis) {
        Queue<Integer> q = new LinkedList<>();
        check[idx] = true;
        q.add(idx);

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i = 1; i <= n; i++) {
                if (map[current][i]) {
                    if (districts[i] == dis && !check[i]) {
                        q.add(i);
                        check[i] = true;
                    }
                }
            }
        }
    }
}
