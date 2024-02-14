import java.io.*;
import java.util.*;

public class Test1197 {
    static class Info {
        int cur, val;

        public Info(int cur, int val) {
            this.cur = cur;
            this.val = val;
        }
    }

    static ArrayList<Info>[] map;
    static boolean[] check;
    static int v, e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        v = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1]);
        map = new ArrayList[v + 1];
        check = new boolean[v + 1];

        for (int i = 0; i <= v; i++)
            map[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            input = br.readLine().split("\\s+");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int val = Integer.parseInt(input[2]);
            map[s].add(new Info(e, val));
            map[e].add(new Info(s, val));
        }

        PriorityQueue<Info> pq = new PriorityQueue<>((Info m1, Info m2) -> m1.val - m2.val);
        pq.add(new Info(1, 0));
        int answer = 0, count = 0;
        while (!pq.isEmpty()) {
            Info temp = pq.poll();
            if (count == v)
                break;
            if (check[temp.cur])
                continue;
            check[temp.cur] = true;
            answer += temp.val;
            count++;
            for (Info next : map[temp.cur])
                if (!check[next.cur])
                    pq.add(next);
        }

        System.out.println(answer);
    }
}
