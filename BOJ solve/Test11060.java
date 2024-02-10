import java.io.*;
import java.util.*;

public class Test11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            list[i] = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (temp[0] == n - 1) {
                System.out.println(temp[1]);
                System.exit(0);
            }
            for (int i = 1; i <= list[temp[0]]; i++) {
                if (temp[0] + i < n)
                    if (dp[temp[0] + i] > temp[1] + 1) {
                        dp[temp[0] + i] = temp[1] + 1;
                        q.add(new int[] { temp[0] + i, temp[1] + 1 });
                    }
            }
        }

        System.out.println(-1);
    }
}
