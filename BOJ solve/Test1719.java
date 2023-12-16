import java.io.*;
import java.util.*;

class Test1719 {
    static class Info {
        int end, val;

        Info(int end, int val) {
            this.end = end;
            this.val = val;
        }
    }

    static int[][] map, answerMap;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n + 1][n + 1];
        answerMap = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            input = br.readLine().split("\\s+");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int t = Integer.parseInt(input[2]);
            map[s][e] = t;
            map[e][s] = t;
        }

        for (int i = 1; i <= n; i++) {
            find(i);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                System.out.print((answerMap[i][j] == 0 ? "-" : answerMap[i][j]) + " ");
            System.out.println();
        }
    }

    private static void find(int num) {
        boolean[] check = new boolean[n + 1];
        int[] list = new int[n + 1];
        PriorityQueue<Info> pq = new PriorityQueue<>((Info i1, Info i2) -> i1.val - i2.val);

        Arrays.fill(list, Integer.MAX_VALUE);
        list[num] = 0;
        pq.add(new Info(num, 0));

        while (!pq.isEmpty()) {
            Info temp = pq.poll();
            if (list[temp.end] < temp.val)
                continue;
            for (int i = 1; i <= n; i++) {
                if (map[temp.end][i] != 0) {
                    Info next = new Info(i, map[temp.end][i]);
                    if (!check[next.end] && temp.val + next.val < list[next.end]) {
                        list[next.end] = temp.val + next.val;
                        answerMap[next.end][num] = temp.end;
                        pq.add(new Info(next.end, list[next.end]));
                    }
                }
            }
        }
    }
}