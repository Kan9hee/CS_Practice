import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Test2342 {
    private static List<Integer> steps;
    private static int[][][] dp;
    private static int[][] powers = {
            { 1, 2, 2, 2, 2 },
            { 0, 1, 3, 4, 3 },
            { 0, 3, 1, 3, 4 },
            { 0, 4, 3, 1, 3 },
            { 0, 3, 4, 3, 1 }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        steps = new ArrayList<>();
        while (st.hasMoreTokens())
            steps.add(Integer.parseInt(st.nextToken()));

        dp = new int[steps.size()][5][5];
        System.out.println(search(0, 0, 0));
    }

    private static int search(int index, int left, int right) {
        if (index == steps.size())
            return 0;
        if (dp[index][left][right] != 0)
            return dp[index][left][right];

        int step = steps.get(index);
        dp[index][left][right] = Math.min(search(index + 1, step, right) + powers[left][step],
                search(index + 1, left, step) + powers[right][step]);

        return dp[index][left][right];
    }
}
