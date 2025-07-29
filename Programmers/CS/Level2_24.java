package CS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Level2_24 {
    public static void main(String[] args) {
        int[] weights = new int[] { 100, 180, 360, 100, 270 };
        System.out.println(solution(weights));
    }

    private static long solution(int[] weights) {
        Map<Double, Integer> map = new HashMap<>();
        double[] ratios = { 1.0, 2.0 / 3.0, 1.0 / 2.0, 3.0 / 4.0 };
        long answer = 0;

        Arrays.sort(weights);
        for (int weight : weights) {
            for (int i = 0; i < ratios.length; i++) {
                double temp = weight * ratios[i];
                if (map.containsKey(temp))
                    answer += map.get(temp);
            }
            double doubleWeight = weight * 1.0;
            map.put(doubleWeight, map.getOrDefault((doubleWeight), 0) + 1);
        }

        return answer;
    }
}
