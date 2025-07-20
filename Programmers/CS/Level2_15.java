package CS;

public class Level2_15 {
    public static void main(String[] args) {
        System.out.println(solution(2, 3));
    }

    private static long solution(int r1, int r2) {
        long answer = 0;

        long minRadiusPow = (long) Math.pow(r1, 2);
        long maxRadiusPow = (long) Math.pow(r2, 2);

        for (int x = 1; x <= r2; x++) {
            long currentXPow = (long) Math.pow(x, 2);
            long maxY = (long) Math.floor(Math.sqrt(maxRadiusPow - currentXPow));
            long minY = 0;
            if (x < r1)
                minY = (long) Math.ceil(Math.sqrt(minRadiusPow - currentXPow));

            if (maxY >= minY)
                answer += (maxY - minY + 1);
        }

        return answer * 4;
    }
}
