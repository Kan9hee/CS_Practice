import java.io.*;
import java.util.*;

public class Test2098 {
    static int[][] map, dp;
    static int n, INF = 16000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][(1 << n) - 1];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(input[j]);
        }

        System.out.println(DFS(0, 1));
    }

    private static int DFS(int num, int checkBit) {
        if (checkBit == (1 << n) - 1) {
            if (map[num][0] == 0)
                return INF;
            return map[num][0];
        }
        if (dp[num][checkBit] != -1)
            return dp[num][checkBit];
        dp[num][checkBit] = INF;
        for (int i = 0; i < n; i++)
            if (map[num][i] != 0 && (checkBit & (1 << i)) == 0)
                dp[num][checkBit] = Math.min(DFS(i, checkBit | (1 << i)) + map[num][i], dp[num][checkBit]);
        return dp[num][checkBit];
    }
}
