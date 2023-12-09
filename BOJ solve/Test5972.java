import java.io.*;
import java.util.*;

public class Test5972 {
    static class Info {
        int end, val;

        Info(int end, int val) {
            this.end = end;
            this.val = val;
        }
    }

    static ArrayList<Info>[] map;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            map[i] = new ArrayList<Info>();

        for (int i = 0; i < m; i++) {
            input = br.readLine().split("\\s+");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int val = Integer.parseInt(input[2]);
            map[start].add(new Info(end, val));
            map[end].add(new Info(start, val));
        }

        PriorityQueue<Info> pq = new PriorityQueue<>((Info f1, Info f2) -> f1.val - f2.val);
        int[] list = new int[n + 1];
        boolean[] check = new boolean[n + 1];
        Arrays.fill(list, 1000 * n);
        list[1] = 0;
        pq.add(new Info(1, 0));
        while (!pq.isEmpty()) {
            Info temp = pq.poll();
            if (check[temp.end])
                continue;
            check[temp.end] = true;
            for (Info next : map[temp.end]) {
                if (list[next.end] > list[temp.end] + next.val) {
                    list[next.end] = list[temp.end] + next.val;
                    pq.add(new Info(next.end, list[next.end]));
                }
            }
        }

        System.out.println(list[n]);
    }
}
