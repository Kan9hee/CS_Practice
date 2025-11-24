package CS;

import java.util.Stack;

public class Level2_32 {
    public static void main(String[] args) {
        int[] result = solution(new int[] { 1, 2, 3, 2, 3 });
        for (int r : result)
            System.out.println(r);
    }

    private static int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--)
            stack.push(prices[i]);

        for (int i = 0; i < n; i++) {
            int temp = stack.pop();
            int count = 0;
            for (int j = stack.size() - 1; j >= 0; j--) {
                count++;
                if (stack.get(j) < temp)
                    break;
            }
            answer[i] = count;
        }

        return answer;
    }
}
