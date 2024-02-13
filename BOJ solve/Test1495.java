import java.io.*;
import java.util.*;

public class Test1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[2]);

        int[] v = new int[n];
        int[] dp = new int[m + 1]; // 나올 수 있는 모든 음량대 배열

        input = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++)
            v[i] = Integer.parseInt(input[i]);

        Arrays.fill(dp, -1);
        dp[s] = 0;

        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j <= m; j++) {
                if (dp[j] == i - 1) {
                    if (j - v[i - 1] >= 0)
                        arr.add(j - v[i - 1]);
                    if (j + v[i - 1] <= m)
                        arr.add(j + v[i - 1]);
                }
            }
            for (int val : arr)
                dp[val] = i; // 음량대 배열에 i번째 곡 갱신
        }

        int answer = -1;
        for (int i = 0; i <= m; i++)
            if (dp[i] == n)
                answer = Math.max(answer, i); // n번째에 부른 음량의 최대 크기 갱신

        System.out.println(answer);
    }
}
