package CS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level3_29 {
    List<Integer> selectedDices = new ArrayList<>();
    List<Integer> diceSumListA, diceSumListB;
    int[] result;
    int n, max = 0;

    public int[] solution(int[][] dice) {
        n = dice.length;
        result = new int[n / 2];

        pickDice(0, 0, dice);
        return result;
    }

    private void pickDice(int count, int start, int[][] dice) {
        if (count == n / 2) {
            int winCount = calculate(dice);
            if (max < winCount) {
                max = winCount;
                for (int i = 0; i < selectedDices.size(); i++)
                    result[i] = selectedDices.get(i) + 1;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            selectedDices.add(i);
            pickDice(count + 1, i + 1, dice);
            selectedDices.remove(selectedDices.size() - 1);
        }
    }

    private int calculate(int[][] dice) {
        diceSumListA = new ArrayList<>();
        diceSumListB = new ArrayList<>();

        int[][] diceA = new int[n / 2][6];
        int[][] diceB = new int[n / 2][6];

        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (selectedDices.contains(i))
                diceA[a++] = dice[i];
            else
                diceB[b++] = dice[i];
        }

        sumDiceValues(0, 0, diceA, diceSumListA);
        sumDiceValues(0, 0, diceB, diceSumListB);

        Collections.sort(diceSumListA);
        Collections.sort(diceSumListB);

        int result = 0;
        for (int i = 0; i < diceSumListA.size(); i++) {
            int base = diceSumListA.get(i);
            int start = 0;
            int end = diceSumListB.size() - 1;
            int index = -1;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (base <= diceSumListB.get(mid))
                    end = mid - 1;
                else {
                    index = Math.max(index, mid);
                    start = mid + 1;
                }
            }

            if (index != -1)
                result += index + 1;
        }

        return result;
    }

    private void sumDiceValues(int count, int sum, int[][] dice, List<Integer> arr) {
        if (count == n / 2) {
            arr.add(sum);
            return;
        }

        for (int i = 0; i < 6; i++) {
            int val = sum + dice[count][i];
            sumDiceValues(count + 1, val, dice, arr);
        }
    }
}
