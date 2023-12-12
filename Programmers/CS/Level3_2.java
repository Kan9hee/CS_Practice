package CS;
import java.util.*;

public class Level3_2 {
    public static void main(String[] args) {
        int[] works = { 4, 3, 3 };
        solution(4, works);
    }

    public static long solution(int n, int[] works) {
        PriorityQueue<Integer> workQueue = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;

        for (int i = 0; i < works.length; i++)
            workQueue.add(works[i]);

        for (int i = 0; i < n; i++) {
            int value = workQueue.poll();
            if (value == 0)
                break;
            workQueue.add(--value);
        }

        for (int value : workQueue)
            answer += Math.pow(value, 2);

        return answer;
    }
}
