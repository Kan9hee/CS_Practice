import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] map = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            map[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        int answer = 0;
        int value = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int result = bfs(map, i);
            if (result < value) {
                answer = i;
                value = result;
            }
        }

        System.out.println(answer);
    }

    static int bfs(ArrayList<Integer>[] map, int start) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] check = new boolean[map.length];
        int[] counts = new int[map.length];
        q.add(new int[] { start, 0 });
        check[start] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int now = temp[0];
            counts[now] = temp[1];
            for (int next : map[now]) {
                if (!check[next]) {
                    check[next] = true;
                    q.add(new int[] { next, temp[1] + 1 });
                }
            }
        }

        int result = 0;
        for (int val : counts)
            result += val;

        return result;
    }
}
