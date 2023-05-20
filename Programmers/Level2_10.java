import java.util.*;

public class Level2_10 {
    public static void main(String[] args) {
        int[] tangerine = { 1, 3, 2, 5, 4, 5, 2, 3 };
        System.out.println(solution(6, tangerine));
    }

    public static int solution(int k, int[] tangerine) {
        Map<Integer, Integer> sizeCounts = new HashMap<Integer, Integer>();
        int answer = 0, listCount = 0;

        for (int i : tangerine)
            sizeCounts.put(i, sizeCounts.getOrDefault(i, 0) + 1);

        List<Integer> tangerineBySize = new ArrayList<>(sizeCounts.keySet());
        tangerineBySize.sort((t1, t2) -> sizeCounts.get(t2) - sizeCounts.get(t1));

        while (k > 0) {
            k -= sizeCounts.get(tangerineBySize.get(listCount));
            listCount++;
            answer++;
        }

        return answer;
    }
}
