import java.io.*;

public class Test10164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] target = new int[2];
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        boolean check = false;
        if (k != 0) {
            for (int i = 1, val = 1; i <= n && !check; i++)
                for (int j = 1; j <= m && !check; j++) {
                    if (val == k) {
                        target[0] = i;
                        target[1] = j;
                        check = true;
                    }
                    val++;
                }
        }

        int answer = 1;
        if (target[0] != 0 && target[1] != 0) {
            answer *= dfs(1, 1, target);
            answer *= dfs(target[0], target[1], new int[] { n, m });
        } else
            answer = dfs(1, 1, new int[] { n, m });

        System.out.println(answer);
    }

    private static int dfs(int x, int y, int[] target) {
        if (x == target[0] && y == target[1])
            return 1;
        int val = 0;
        if (x + 1 <= target[0])
            val += dfs(x + 1, y, target);
        if (y + 1 <= target[1])
            val += dfs(x, y + 1, target);
        return val;
    }
}
