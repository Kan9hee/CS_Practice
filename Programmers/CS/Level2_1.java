package CS;
import java.util.*;

public class Level2_1 {

    public static void main(String args[]) {
        System.out.println(solution("()()"));
    }

    private static boolean solution(String s) {
        Queue<Character> check = new LinkedList<>();
        boolean answer = true;

        for (char part : s.toCharArray()) {
            if (part == '(')
                check.add(part);
            else {
                if (!check.isEmpty())
                    check.remove();
                else {
                    answer = false;
                    break;
                }
            }
        }

        if (!check.isEmpty())
            answer = false;

        return answer;
    }
}
