import java.util.*;

public class Level2_4 {

    public static void main(String[] args) {
        int[] sequence = { 1, 2, 3, 4, 5 };
        int[] result = solution(sequence, 7);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] solution(int[] sequence, int k) {

        int[] answer = new int[2];
        int shortest = sequence.length + 1;
        int sum = 0;

        for (int s = 0, e = 0; s < sequence.length; s++) {
            while (e < sequence.length && sum < k)
                sum += sequence[e++];
            if (sum == k && (e - s) < shortest) {
                shortest = e - s;
                answer[0] = s;
                answer[1] = e - 1;
            }
            sum -= sequence[s];
        }

        return answer;
    }

}
