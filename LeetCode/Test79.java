package LeetCode;

import java.util.ArrayList;

public class Test79 {
    class Info {
        int y;
        int x;
        int count;

        Info(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    int[][] move = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        ArrayList<Info> infoList = new ArrayList<>();
        char startWord = word.charAt(0);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == startWord)
                    infoList.add(new Info(i, j, 0));

        for (Info trying : infoList)
            if (DFS(board, word, new boolean[m][n], trying))
                return true;

        return false;
    }

    public boolean DFS(char[][] board, String word, boolean[][] check, Info trying) {
        if (trying.count + 1 == word.length())
            return true;

        for (int[] next : move) {
            int nextM = trying.y + next[0];
            int nextN = trying.x + next[1];
            if (nextM > -1 && nextM < m && nextN > -1 && nextN < n)
                if (!check[nextM][nextN] && board[nextM][nextN] == word.charAt(trying.count + 1)) {
                    check[trying.y][trying.x] = true;
                    boolean result = DFS(board, word, check, new Info(nextM, nextN, trying.count + 1));
                    check[trying.y][trying.x] = false;
                    if (result)
                        return true;
                }
        }

        return false;
    }
}
