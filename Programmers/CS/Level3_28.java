package CS;

import java.util.*;

public class Level3_28 {
    public int solution(int alp, int cop, int[][] problems) {
        int minAlp = 0;
        int minCop = 0;
        int maxAlp = 0;
        int maxCop = 0;

        for (int i = 0; i < problems.length; i++) {
            maxAlp = Math.max(maxAlp, problems[i][0]);
            maxCop = Math.max(maxCop, problems[i][1]);
        }
        if (alp >= maxAlp && cop >= maxCop)
            return 0;
        minAlp = Math.min(alp, maxAlp);
        minCop = Math.min(cop, maxCop);

        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int[] temp : dp)
            Arrays.fill(temp, Integer.MAX_VALUE);
        dp[minAlp][minCop] = 0;

        for (int i = minAlp; i <= maxAlp; i++) {
            for (int j = minCop; j <= maxCop; j++) {
                int temp = dp[i][j];

                if (i + 1 <= maxAlp)
                    dp[i + 1][j] = Math.min(dp[i + 1][j], temp + 1);
                if (j + 1 <= maxCop)
                    dp[i][j + 1] = Math.min(dp[i][j + 1], temp + 1);

                for (int[] problem : problems) {
                    if (i >= problem[0] && j >= problem[1]) {
                        int nextI = Math.min(maxAlp, i + problem[2]);
                        int nextJ = Math.min(maxCop, j + problem[3]);
                        dp[nextI][nextJ] = Math.min(dp[nextI][nextJ], temp + problem[4]);
                    }
                }
            }
        }

        return dp[maxAlp][maxCop];
    }
}
