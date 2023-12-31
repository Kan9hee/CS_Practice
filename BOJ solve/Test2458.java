import java.io.*;
import java.util.*;

public class Test2458 {
    static ArrayList<Integer>[][] map;
    static boolean[] checkList;
    static int n, m, count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new ArrayList[2][n + 1];

        for (int i = 0; i <= n; i++) {
            map[0][i] = new ArrayList<>();
            map[1][i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split("\\s+");
            int low = Integer.parseInt(input[0]);
            int high = Integer.parseInt(input[1]);
            map[0][low].add(high);
            map[1][high].add(low);
        }

        for (int i = 1; i <= n; i++) {
            checkList = new boolean[n + 1];
            int forward = dfs(0, i);
            int backward = dfs(1, i);
            if (forward + backward - 1 == n)
                count++;
        }
        System.out.println(count);
    }

    private static int dfs(int situation, int num) {
        int temp = 1;
        checkList[num] = true;
        for (int next : map[situation][num])
            if (!checkList[next])
                temp += dfs(situation, next);
        return temp;
    }
}
