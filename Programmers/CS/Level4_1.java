package CS;

import java.util.*;

public class Level4_1 {
    public static void main(String[] args) {
        System.out.println(solution(25, new int[] { 2, 14, 11, 21, 17 }, 2));
    }

    public static int solution(int distance, int[] rocks, int n) {
        int s = 1, e = distance, answer = 0;
        Arrays.sort(rocks);

        while (s <= e) {
            int mid = (s + e) / 2;
            if (count(rocks, distance, mid) <= n) {
                answer = mid;
                s = mid + 1;
            } else
                e = mid - 1;
        }

        return answer;
    }

    private static int count(int[] rocks, int distance, int mid) {
        int temp = 0, result = 0;

        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] - temp < mid) {
                result++;
                continue;
            }
            temp = rocks[i];
        }

        if (distance - temp < mid)
            result++;

        return result;
    }
}
