package CS;

import java.util.HashMap;
import java.util.Map;

public class Level3_25 {
    public static void main(String[] args) {
        String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
        int[] result = solution(gems);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>(); // 보석 종류에 따른 각각의 개수
        for (String gem : gems)
            map.put(gem, 0);

        int[] currentNode = new int[2]; // 현재 탐색 범위
        int[] answer = new int[] { 1, gems.length }; // 결과
        int gemKind = map.keySet().size(); // 보석 종류의 수
        int currentKind = 0; // 현재 탐색 종류
        int minLength = gems.length; // 최소범위

        while (currentNode[0] <= currentNode[1]) {
            // gems 끝에 다다르고 보석의 종류가 적을 정도로 범위가 좁혀질 때, 탐색 종료
            if (currentKind < gemKind && currentNode[1] == gems.length)
                break;

            // 현재 탐색 종류가 적을 경우, 탐색 범위의 끝부분을 이동
            // 그렇지 않을 경우, 탐색 범위의 시작부분을 이동
            if (currentKind < gemKind) {
                String gem = gems[currentNode[1]];
                map.put(gem, map.get(gem) + 1);
                if (map.get(gem) == 1)
                    currentKind++;
                currentNode[1]++;
            } else {
                String gem = gems[currentNode[0]];
                map.put(gem, map.get(gem) - 1);
                if (map.get(gem) == 0)
                    currentKind--;
                currentNode[0]++;
            }

            // 현재 탐색 종류가 보석 종류의 수와 같을 경우, 결과값 초기화
            if (currentKind == gemKind) {
                if (minLength > currentNode[1] - currentNode[0] + 1) {
                    minLength = currentNode[1] - currentNode[0] + 1;
                    answer[0] = currentNode[0] + 1;
                    answer[1] = currentNode[1];
                } else if (minLength == currentNode[1] - currentNode[0] + 1 && currentNode[0] + 1 < answer[0]) {
                    answer[0] = currentNode[0] + 1;
                    answer[1] = currentNode[1];
                }
            }
        }

        return answer;
    }
}
