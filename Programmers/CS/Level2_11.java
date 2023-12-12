package CS;
public class Level2_11 {
    public static void main(String[] args) {
        int[][] balls = { { 7, 7 }, { 2, 7 }, { 7, 3 } };
        for (int ans : solution(10, 10, 3, 7, balls)) {
            System.out.println(ans);
        }
    }

    public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for (int i = 0; i < balls.length; i++) {
            int endX = balls[i][0];
            int endY = balls[i][1];
            answer[i] = Integer.MAX_VALUE;

            if (!(startY == endY && startX >= endX)) {
                int len = calculate(startX, startY, -endX, endY);
                answer[i] = len < answer[i] ? len : answer[i];
            }
            if (!(startY == endY && startX <= endX)) {
                int len = calculate(startX, startY, m + (m - endX), endY);
                answer[i] = len < answer[i] ? len : answer[i];
            }
            if (!(startX == endX && startY <= endY)) {
                int len = calculate(startX, startY, endX, n + (n - endY));
                answer[i] = len < answer[i] ? len : answer[i];
            }
            if (!(startX == endX && startY >= endY)) {
                int len = calculate(startX, startY, endX, -endY);
                answer[i] = len < answer[i] ? len : answer[i];
            }
        }

        return answer;
    }

    private static int calculate(int sx, int sy, int ex, int ey) {
        return (int) (Math.pow(sx - ex, 2) + Math.pow(sy - ey, 2));
    }
}
