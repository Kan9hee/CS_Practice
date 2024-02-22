package CS;

import java.util.Arrays;

public class Level4_2 {
    public static void main(String[] args) {
        String[] words = { "go", "gone", "guild" };
        System.out.println(solution(words));
    }

    public static int solution(String[] words) {
        int answer = 0;
        int[] countList = new int[words.length];
        Arrays.sort(words); // 주어진 단어들을 알파벳 사전 순으로 정렬한다.

        for (int i = 0; i < words.length - 1; i++) {
            String current = words[i];
            String next = words[i + 1];
            int minLength = Math.min(current.length(), next.length()); // 현재,다음 단어 중 짧은 길이
            int sameLength = 0; // 현재,다음 단어와의 유사 길이

            for (int j = 0; j < minLength; j++) {
                if (current.charAt(j) != next.charAt(j))
                    break;
                sameLength++;
            }

            if (minLength == sameLength) // 최단 길이와 유사 길이가 같을 경우(같은 단어)
                countList[i] = Math.max(countList[i], sameLength);
            else // 아닐 경우, 유사 길이 + 1이 현재 단어를 구분하는 데 필요한 길이가 된다.
                countList[i] = Math.max(countList[i], sameLength + 1);

            // 다음 단어의 경우 현재 단어와 구분할 경우만 고려하므로, 일단 유사 길이 + 1을 요구한다.
            // 만약 값이 아니더라도 다음다음 단어와 구분하는 과정을 거치므로 상관 없다.
            countList[i + 1] = Math.max(countList[i + 1], sameLength + 1);
        }

        for (int n : countList)
            answer += n;

        return answer;
    }
}
