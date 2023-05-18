public class Level2_8 {

    public static void main(String[] args) {
        int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };
        for (int n : solution(6, 6, queries)) {
            System.out.println(n);
        }
    }

    public static int[] solution(int rows, int columns, int[][] queries) {

        int[][] map = new int[rows][columns];
        int[] answer = new int[queries.length];
        int caseCount = 0;

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++)
                map[r][c] = 1 + c + r * columns;

        for (int[] cases : queries) {
            int x1 = cases[1] - 1;
            int y1 = cases[0] - 1;
            int x2 = cases[3] - 1;
            int y2 = cases[2] - 1;
            int save = map[y1][x2];
            int minValue = rows * columns;

            for (int i = x2; i > x1; i--) {
                minValue = Math.min(minValue, map[y1][i]);
                map[y1][i] = map[y1][i - 1];
            }
            for (int i = y1; i < y2; i++) {
                minValue = Math.min(minValue, map[i][x1]);
                map[i][x1] = map[i + 1][x1];
            }
            for (int i = x1; i < x2; i++) {
                minValue = Math.min(minValue, map[y2][i]);
                map[y2][i] = map[y2][i + 1];
            }
            for (int i = y2; i > y1; i--) {
                minValue = Math.min(minValue, map[i][x2]);
                map[i][x2] = map[i - 1][x2];
            }

            map[y1 + 1][x2] = save;
            answer[caseCount++] = minValue;
        }

        return answer;
    }
}
