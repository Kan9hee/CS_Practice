package CS;

import java.util.HashSet;

public class Level2_26 {
    public static void main(String[] args) {
        int[] elements = { 7, 9, 1, 1, 4 };
        System.out.println(solution(elements));
    }

    private static int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int[] dp = new int[elements.length];

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int endPoint = j + i;
                if (endPoint >= elements.length)
                    endPoint -= elements.length;
                dp[j] += elements[endPoint];
                set.add(dp[j]);
            }
        }

        return set.size();
    }
}
