package CS;

import java.util.*;

public class Level2_18 {
    public static void main(String[] args) {
        String[] maps = { "X591X", "X1X5X", "X231X", "1XXX1" };
        int[] result = solution(maps);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }

    private static int[][] arrayMap;
    private static int[] xMove = { 1, 0, 0, -1 };
    private static int[] yMove = { 0, 1, -1, 0 };
    private static int xLength, yLength;

    public static int[] solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        yLength = maps.length;
        xLength = maps[0].length();
        arrayMap = new int[yLength][xLength];
        for (int i = 0; i < yLength; i++) {
            for (int j = 0; j < xLength; j++) {
                if (maps[i].charAt(j) == 'X')
                    arrayMap[i][j] = -1;
                else
                    arrayMap[i][j] = Character.getNumericValue(maps[i].charAt(j));
            }
        }

        for (int i = 0; i < yLength; i++) {
            for (int j = 0; j < xLength; j++) {
                if (arrayMap[i][j] != -1)
                    answer.add(BFS(new int[] { i, j }));
            }
        }

        if (answer.isEmpty())
            answer.add(-1);

        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int BFS(int[] start) {
        Queue<int[]> q = new LinkedList<>();
        int result = arrayMap[start[0]][start[1]];

        q.add(start);
        arrayMap[start[0]][start[1]] = -1;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + yMove[i];
                int nextX = temp[1] + xMove[i];
                if (nextY >= 0 && nextY < yLength && nextX >= 0 && nextX < xLength) {
                    if (arrayMap[nextY][nextX] != -1) {
                        result += arrayMap[nextY][nextX];
                        arrayMap[nextY][nextX] = -1;
                        q.add(new int[] { nextY, nextX });
                    }
                }
            }
        }

        return result;
    }
}
