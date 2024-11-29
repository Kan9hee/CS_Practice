package LeetCode;

import java.util.*;

public class Test417 {
    static int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
            { 5, 1, 1, 2, 4 } };
    static int[][] moves = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String args[]) {
        int xLength = heights[0].length;
        int yLength = heights.length;

        boolean[][] paCheck = new boolean[yLength][xLength];
        boolean[][] atCheck = new boolean[yLength][xLength];
        Queue<int[]> tempQueue = new LinkedList<>();

        for (int i = 0; i < xLength; i++) {
            if (i == 0) {
                for (int j = 0; j < yLength; j++) {
                    tempQueue.add(new int[] { j, i });
                    paCheck[j][i] = true;
                }
            } else {
                tempQueue.add(new int[] { 0, i });
                paCheck[0][i] = true;
            }
        }

        while (!tempQueue.isEmpty()) {
            int[] temp = tempQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + moves[i][0];
                int nextX = temp[1] + moves[i][1];

                if (nextY >= 0 && nextY < yLength && nextX >= 0 && nextX < xLength)
                    if (!paCheck[nextY][nextX] && heights[nextY][nextX] >= heights[temp[0]][temp[1]]) {
                        paCheck[nextY][nextX] = true;
                        tempQueue.add(new int[] { nextY, nextX });
                    }
            }
        }

        tempQueue.clear();
        for (int i = xLength - 1; i >= 0; i--) {
            if (i == xLength - 1) {
                for (int j = 0; j < yLength; j++) {
                    tempQueue.add(new int[] { j, i });
                    atCheck[j][i] = true;
                }
            } else {
                tempQueue.add(new int[] { yLength - 1, i });
                atCheck[yLength - 1][i] = true;
            }
        }

        while (!tempQueue.isEmpty()) {
            int[] temp = tempQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + moves[i][0];
                int nextX = temp[1] + moves[i][1];

                if (nextY >= 0 && nextY < yLength && nextX >= 0 && nextX < xLength)
                    if (!atCheck[nextY][nextX] && heights[nextY][nextX] >= heights[temp[0]][temp[1]]) {
                        atCheck[nextY][nextX] = true;
                        tempQueue.add(new int[] { nextY, nextX });
                    }
            }
        }

        tempQueue.clear();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < xLength; i++)
            for (int j = 0; j < yLength; j++)
                if (paCheck[j][i] && atCheck[j][i])
                    result.add(new ArrayList<Integer>(Arrays.asList(j, i)));

    }
}
