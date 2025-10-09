package CS;

import java.util.*;

public class Level3_27 {
    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
        int[] course = { 2, 3, 4 };
        String[] result = solution(orders, course);

        for (String r : result)
            System.out.println(r);
    }

    public static String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            orders[i] = String.valueOf(temp);
        }

        for (String order : orders) {
            for (int len : course)
                if (order.length() >= len)
                    DFS(order, len, "", 0);
        }

        List<String> answer = new ArrayList<>();
        for (int num : course) {
            int max = 0;
            for (String key : map.keySet()) {
                if (key.length() == num) {
                    Integer count = map.get(key);
                    if (count >= 2 && max < count) {
                        max = count;
                        answer.removeIf(ans -> ans.length() == num);
                    }
                    if (count == max)
                        answer.add(key);
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(String[]::new);
    }

    private static void DFS(String order, int len, String word, int start) {
        if (word.length() == len)
            map.put(word, map.getOrDefault(word, 0) + 1);
        else {
            for (int i = start; i < order.length(); i++)
                DFS(order, len, word + order.charAt(i), i + 1);
        }
    }
}
