import java.io.*;
import java.util.*;

public class Test9205 {
    static ArrayList<int[]> list;
    static int[] start = new int[2], end = new int[2];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();

            for (int j = 0; j <= n + 1; j++) {
                String[] input = br.readLine().split("\\s+");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                if (j == 0) {
                    start[0] = Integer.parseInt(input[0]);
                    start[1] = Integer.parseInt(input[1]);
                } else if (j == n + 1) {
                    end[0] = Integer.parseInt(input[0]);
                    end[1] = Integer.parseInt(input[1]);
                } else
                    list.add(new int[] { x, y });
            }

            bfs();
        }
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[] check = new boolean[n];
        q.add(start);

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (Math.abs(temp[0] - end[0]) + Math.abs(temp[1] - end[1]) <= 1000) {
                System.out.println("happy");
                return;
            }
            for (int i = 0; i < n; i++) {
                if (!check[i]) {
                    int[] next = list.get(i);
                    if (Math.abs(temp[0] - next[0]) + Math.abs(temp[1] - next[1]) <= 1000) {
                        check[i] = true;
                        q.add(next);
                    }
                }
            }
        }

        System.out.println("sad");
    }
}
