package CS;

import java.util.ArrayList;

public class Level2_28 {
    private static ArrayList<int[]> shots = new ArrayList<>();
    private static int[] champion = new int[11];

    public static void main(String[] args) {
        int n = 5;
        int[] info = { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
        int[] ans = solution(n, info);
        for (int i : ans)
            System.out.print(i + " ");
    }

    private static int[] solution(int n, int[] info) {
        int[] answer = {};

        int challengerScore = 0;
        for (int i = 0; i < 11; i++)
            if (info[i] > 0)
                challengerScore += (10 - i);

        int maxPoint = calculate(0, n, -challengerScore, -challengerScore, info);

        if (maxPoint <= 0)
            answer = new int[] { -1 };
        else {
            for (int i = 0; i < 11; i++) {
                if (shots.size() == 1)
                    break;
                int maxCount = 0;
                for (int[] shot : shots)
                    maxCount = Math.max(shot[10 - i], maxCount);

                int s = 0;
                while (s < shots.size()) {
                    if (shots.get(s)[10 - i] != maxCount)
                        shots.remove(s);
                    else
                        s++;
                }
            }
            answer = shots.get(0);
        }

        return answer;
    }

    private static int calculate(int index, int n, int nowPoint, int maxPoint, int challenger[]) {
        if (n == 0) {
            if (nowPoint > maxPoint) {
                maxPoint = nowPoint;
                shots = new ArrayList<>();
                shots.add(champion.clone());
            } else if (nowPoint == maxPoint)
                shots.add(champion.clone());
            return maxPoint;
        } else if (n >= 0 && index < 11) {
            for (int i = 0; i <= challenger[index] + 1; i++) {
                champion[index] += i;
                int nextPoint = nowPoint;
                if (champion[index] > challenger[index]) {
                    if (challenger[index] == 0)
                        nextPoint += (10 - index);
                    else if (challenger[index] > 0)
                        nextPoint += (10 - index) * 2;
                }
                maxPoint = calculate(index + 1, n - i, nextPoint, maxPoint, challenger);
                champion[index] -= i;
            }
        }
        return maxPoint;
    }
}
