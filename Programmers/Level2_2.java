import java.util.*;

public class Level2_2 {
    public static void main(String[] args) {
        int[] numbers = { 9, 1, 5, 3, 6, 2 };
        for (int i : solution(numbers))
            System.out.println(i);
    }

    public static int[] solution(int[] numbers) {

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];

        Arrays.fill(answer, -1);
        stack.push(0);

        for (int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i])
                answer[stack.pop()] = numbers[i];
            stack.push(i);
        }

        return answer;
    }
}