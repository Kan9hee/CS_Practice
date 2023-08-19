import java.util.Arrays;
import java.util.Comparator;

public class Level3_8 {
    public static void main(String[] args) {
        int[][] routes = { { -20, -15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
        System.out.println(solution(routes));
    }

    public static int solution(int[][] routes) {
        int currentCamera = Integer.MIN_VALUE;
        int answer = 0;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return x[1] - y[1];
            }
        });

        for (int[] route : routes)
            if (currentCamera < route[0]) {
                currentCamera = route[1];
                answer++;
            }

        return answer;
    }
}
