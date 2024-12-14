package LeetCode;

public class Test200 {
    int maxY, maxX;

    public int numIslands(char[][] grid) {
        maxY = grid.length;
        maxX = grid[0].length;

        int result = 0;
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                if (grid[i][j] == '1') {
                    DFS(i, j, grid);
                    result++;
                }
            }
        }

        return result;
    }

    public void DFS(int y, int x, char[][] grid) {
        if (y < 0 || y >= maxY || x < 0 || x >= maxX || grid[y][x] == '0')
            return;

        grid[y][x] = '0';

        DFS(y + 1, x, grid);
        DFS(y - 1, x, grid);
        DFS(y, x + 1, grid);
        DFS(y, x - 1, grid);
    }
}