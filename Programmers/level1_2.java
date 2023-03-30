import java.util.Arrays;
import java.util.Collections;

class level1_2 {
    public static void main(String[] args) {
        String players[] = { "mumu", "soe", "poe", "kai", "mine" };
        String callings[] = { "kai", "kai", "mine", "mine" };
        String result[] = solution(players, callings);
        for (String name : result) {
            System.out.println(name);
        }
    }

    public static String[] solution(String[] players, String[] callings) {

        String[] answer = players;
        int overtake = 0;
        String runner = callings[0];

        for (String player : callings) {
            if (!runner.equals(player)) {
                answer = changeRank(answer, runner, overtake);
                runner = player;
                overtake = 0;
            }
            overtake++;
        }
        answer = changeRank(answer, runner, overtake);

        return answer;
    }

    private static String[] changeRank(String[] players, String runner, int count) {
        int previousRank = 0, currentRank = 0;
        previousRank = Arrays.asList(players).indexOf(runner);
        currentRank = (previousRank - count < 0) ? 0 : previousRank - count;
        Collections.swap(Arrays.asList(players), currentRank, previousRank);
        return players;
    }
}
