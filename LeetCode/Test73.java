package LeetCode;

public class Test73 {
    public void setZeroes(int[][] matrix) {
        int yMax = matrix.length;
        int xMax = matrix[0].length;

        boolean firstY_zeroCheck = false;
        boolean firstX_zeroCheck = false;

        for (int i = 0; i < yMax; i++)
            if (matrix[i][0] == 0)
                firstY_zeroCheck = true;
        for (int i = 0; i < xMax; i++)
            if (matrix[0][i] == 0)
                firstX_zeroCheck = true;

        for (int i = 1; i < yMax; i++) {
            for (int j = 1; j < xMax; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < yMax; i++)
            for (int j = 1; j < xMax; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

        for (int i = 0; i < yMax; i++)
            if (firstY_zeroCheck)
                matrix[i][0] = 0;
        for (int i = 0; i < xMax; i++)
            if (firstX_zeroCheck)
                matrix[0][i] = 0;
    }
}
