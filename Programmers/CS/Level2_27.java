package CS;

import java.util.HashMap;
import java.util.Map;

public class Level2_27 {
    public static void main(String[] args) {
        String[] want = { "banana", "apple", "rice", "pork", "pot" };
        int[] number = { 3, 2, 2, 2, 1 };
        String[] discount = { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
                "pot", "banana", "apple", "banana" };
        System.out.println(solution(want, number, discount));
    }

    private static int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;
        int days = 10;

        for (int i = 0; i < want.length; i++)
            map.put(want[i], number[i]);

        for (int i = 0; i < discount.length - days + 1; i++) {
            Map<String, Integer> tempMap = new HashMap<>();

            for (int j = 0; j < days; j++)
                tempMap.put(discount[i + j], tempMap.getOrDefault(discount[i + j], 0) + 1);

            answer += check(map, tempMap) ? 1 : 0;
        }

        return answer;
    }

    private static boolean check(Map<String, Integer> map, Map<String, Integer> tempMap) {
        for (String key : map.keySet())
            if (map.get(key) != tempMap.get(key))
                return false;

        return true;
    }
}
