package CS;
public class Level3_5 {
    static boolean[] check;
    static String[] staticWords;
    static String staticTarget;
    static int answer = 0;

    public static void main(String[] args) {
        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
        System.out.println(solution("hit", "cog", words));
    }

    public static int solution(String begin, String target, String[] words) {
        check = new boolean[words.length];
        staticWords = words;
        staticTarget = target;

        find(begin, 0);
        return answer;
    }

    private static void find(String current, int count) {
        if (current.equals(staticTarget)) {
            answer = count;
            return;
        }

        for (int i = 0; i < staticWords.length; i++) {
            if (check[i])
                continue;

            int compare = 0;
            for (int w = 0; w < current.length(); w++)
                if (current.charAt(w) != staticWords[i].charAt(w))
                    compare++;

            if (compare == 1) {
                check[i] = true;
                find(staticWords[i], count + 1);
                check[i] = false;
            }
        }
    }
}
