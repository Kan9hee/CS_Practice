package CS;
import java.util.*;

public class Level2_5 {
    public static void main(String[] args) {
        int[] queue1 = { 1, 2, 1, 2 };
        int[] queue2 = { 1, 10, 1, 2 };
        System.out.println(solution(queue1, queue2));
    }

    public static int solution(int[] queue1, int[] queue2) {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int answer = 0;
        long q1sum = 0, q2sum = 0;

        for (int c = 0; c < queue1.length; c++) {
            q1.add(queue1[c]);
            q1sum += queue1[c];
            q2.add(queue2[c]);
            q2sum += queue2[c];
        }

        while (q1sum != q2sum) {
            answer++;
            if (q1sum > q2sum) {
                int value = q1.poll();
                q2.add(value);
                q1sum -= value;
                q2sum += value;
            } else if (q1sum < q2sum) {
                int value = q2.poll();
                q1.add(value);
                q2sum -= value;
                q1sum += value;
            }
            if (answer > (queue1.length + queue2.length) * 2) {
                answer = -1;
                break;
            }
        }

        return answer;
    }
}
