import java.io.*;
import java.util.*;

public class Test1922 {
    private static class Info {
        int s, e, val;

        Info(int s, int e, int val) {
            this.s = s;
            this.e = e;
            this.val = val;
        }
    }

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Info> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list.add(new Info(start, end, val));
        }
        Collections.sort(list, (n1, n2) -> n1.val - n2.val);

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parents[i] = i;

        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            Info temp = list.get(i);
            if (find(temp.s) != find(temp.e)) {
                result += temp.val;
                union(temp.s, temp.e);
            }
        }

        System.out.println(result);
    }

    static int find(int x) {
        if (x == parents[x])
            return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y)
            parents[y] = x;
    }
}
