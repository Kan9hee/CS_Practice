import java.io.*;
import java.util.*;

public class Test1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            ArrayList<Integer>[] ways = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++)
                ways[i] = new ArrayList<>();

            int[] list = new int[n + 1];
            input = br.readLine().split("\\s+");
            for (int i = 0; i < n; i++)
                list[i + 1] = Integer.parseInt(input[i]);

            for (int i = 0; i < k; i++) {
                input = br.readLine().split("\\s+");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                ways[y].add(x);
            }

            int[] dp = new int[n + 1];
            int start = Integer.parseInt(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            dp[start] = list[start];
            q.add(start);
            while (!q.isEmpty()) {
                int temp = q.poll();
                list[0] = Math.max(list[0], dp[temp]);
                for (int next : ways[temp]) {
                    if (dp[next] < dp[temp] + list[next]) {
                        dp[next] = dp[temp] + list[next];
                        q.add(next);
                    }
                }
            }

            System.out.println(list[0]);
        }
    }
}
