package CS;

public class Level3_21 {
    public static void main(String[] args) {
        int[] sequence = { 2, 3, -6, 1, 3, -1, 2, 4 };
        System.out.println(solution(sequence));
    }

    public static long solution(int[] sequence) {
        long answer = 0;
        long[][] dp = new long[sequence.length][2];

        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];

        for (int i = 1; i < sequence.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], 0) + sequence[i];
            dp[i][1] = Math.max(dp[i - 1][0], 0) - sequence[i];
        }

        for (long[] ans : dp)
            answer = Math.max(answer, Math.max(ans[0], ans[1]));

        return answer;
    }
}
