package CS;

public class Level2_20 {
    public static void main(String[] args) {
        int[] picks = { 1, 3, 2 };
        String[] minerals = { "diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone" };

        int result = solution(picks, minerals);
        System.out.println(result);
    }

    private static int[][] fatigueTable = { { 1, 1, 1 }, { 5, 1, 1 }, { 25, 5, 1 } };

    public static int solution(int[] picks, String[] minerals) {
        int answer = DFS(picks, minerals, 0, 0);
        return answer;
    }

    public static int DFS(int[] picks, String[] minerals, int currentMineral, int totalFatigue) {
        if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0 || currentMineral == minerals.length)
            return totalFatigue;

        int currentResult = 0;
        for (int i = 0; i < 3; i++) {
            if (picks[i] == 0)
                continue;

            picks[i]--;
            int sum = 0;
            int nextMineral = currentMineral;
            for (; nextMineral < currentMineral + 5 && nextMineral < minerals.length; nextMineral++) {
                if (minerals[nextMineral].equals("diamond"))
                    sum += fatigueTable[i][0];
                else if (minerals[nextMineral].equals("iron"))
                    sum += fatigueTable[i][1];
                else
                    sum += fatigueTable[i][2];
            }

            int result = DFS(picks, minerals, nextMineral, totalFatigue + sum);
            if (currentResult == 0)
                currentResult = result;
            else
                currentResult = Math.min(currentResult, result);

            picks[i]++;
        }

        return currentResult;
    }
}
