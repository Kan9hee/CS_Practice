package CS;

public class Level3_18 {
    public static void main(String[] args) {
        int[][] maps = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 },
                { 4, 5, 2, 6, 5 } };
        System.out.println(solution(maps));
    }

    public static int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;

        int[][] dp = new int[height][height];
        dp[0][0] = triangle[0][0];

        for (int i = 0; i < height - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + triangle[i + 1][j]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + triangle[i + 1][j + 1]);
            }
        }

        for (int i = 0; i < height; i++)
            answer = Math.max(answer, dp[height - 1][i]);

        return answer;
    }
}
