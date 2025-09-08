package CS;

import java.util.Arrays;

public class Level3_23 {
    public static void main(String[] args) {
        int[] result = solution(2, 8);
        for (int i : result)
            System.out.println(i);
    }

    public static int[] solution(int n, int s) {
        if (s < n)
            return new int[] { -1 };
        int[] answer = new int[n];

        Arrays.fill(answer, s / n);
        for (int i = 0; i < s % n; i++)
            answer[n - 1 - i]++;
        return answer;
    }
}
