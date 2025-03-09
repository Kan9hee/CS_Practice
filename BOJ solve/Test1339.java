import java.util.*;

public class Test1339 {
    static class AlphaInfo {
        char alphabet;
        int weight;

        AlphaInfo(char alphabet, int weight) {
            this.alphabet = alphabet;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        ArrayList<String> words = new ArrayList<>();
        Map<Character, Integer> weightMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = sc.nextLine();
            words.add(word);
            int len = word.length();

            for (int j = 0; j < len; j++) {
                char ch = word.charAt(j);
                int weight = (int) Math.pow(10, len - j - 1);
                weightMap.put(ch, weightMap.getOrDefault(ch, 0) + weight);
            }
        }

        PriorityQueue<AlphaInfo> pq = new PriorityQueue<>((a1, a2) -> a2.weight - a1.weight);
        for (Map.Entry<Character, Integer> entry : weightMap.entrySet()) {
            pq.add(new AlphaInfo(entry.getKey(), entry.getValue()));
        }

        Map<Character, Integer> alphaToNum = new HashMap<>();
        int val = 9;
        while (!pq.isEmpty()) {
            AlphaInfo info = pq.poll();
            alphaToNum.put(info.alphabet, val--);
        }

        int result = 0;
        for (String word : words) {
            int num = 0;
            for (char ch : word.toCharArray()) {
                num = num * 10 + alphaToNum.get(ch);
            }
            result += num;
        }

        System.out.println(result);
        sc.close();
    }
}
