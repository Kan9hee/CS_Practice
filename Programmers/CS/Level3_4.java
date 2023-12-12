package CS;
import java.util.*;

public class Level3_4 {
    public static void main(String[] args) {
        String[] numbers = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
        for (int i : solution(numbers)) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] operations) {
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer tokenizer;

        for (String operation : operations) {
            tokenizer = new StringTokenizer(operation);
            String order = tokenizer.nextToken();
            int value = Integer.valueOf(tokenizer.nextToken());

            if (order.equals("I")) {
                list.add(value);
            } else {
                if (!list.isEmpty()) {
                    if (value == 1)
                        list.remove(0);
                    else
                        list.remove(list.size() - 1);
                }
            }
            Collections.sort(list, Collections.reverseOrder());
        }

        if (list.isEmpty())
            return new int[] { 0, 0 };

        return new int[] { list.get(0), list.get(list.size() - 1) };
    }
}
