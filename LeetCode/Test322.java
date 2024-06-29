package LeetCode;

import java.util.Arrays;

public class Test322 {
    public int coinChange(int[] coins, int amount) {
        int[] vals = new int[amount + 1];
        Arrays.fill(vals, Integer.MAX_VALUE);
        vals[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && vals[i - coin] != Integer.MAX_VALUE)
                    vals[i] = Math.min(vals[i], 1 + vals[i - coin]);
            }
        }

        if (vals[amount] == Integer.MAX_VALUE)
            return -1;
        return vals[amount];
    }
}
