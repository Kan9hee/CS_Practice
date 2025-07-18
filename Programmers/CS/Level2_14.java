package CS;

import java.util.*;

public class Level2_14 {
    public static void main(String[] args) {
        int[][] targets = { { 4, 5 }, { 4, 8 }, { 10, 14 }, { 11, 13 }, { 5, 12 }, { 3, 7 }, { 1, 4 } };
        System.out.println(solution(targets));
    }

    public static int solution(int[][] targets) {
        int result = 0;
        Arrays.sort(targets, (t1, t2) -> t1[1] - t2[1]);

        int beforeTarget = -1;
        for (int[] target : targets) {
            if (beforeTarget < target[0] || beforeTarget > target[1]) {
                result++;
                beforeTarget = target[1] - 1;
            }
        }

        return result;
    }
}
