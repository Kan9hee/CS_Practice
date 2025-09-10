package CS;

import java.util.LinkedList;
import java.util.Queue;

public class Level3_24 {
    public static void main(String[] args) {
        int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        System.out.println(solution(board));
    }

    private static class Node {
        int x, y, dir, cost;

        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    private static int[] xMove = { -1, 0, 1, 0 };
    private static int[] yMove = { 0, 1, 0, -1 };

    private static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        int[][][] dp = new int[n][n][4];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < 4; k++)
                    dp[i][j][k] = Integer.MAX_VALUE;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, 0));
        q.add(new Node(0, 0, 2, 0));
        dp[0][0][1] = 0;
        dp[0][0][2] = 0;

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp.x == n - 1 && temp.y == n - 1) {
                answer = Math.min(answer, temp.cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = temp.x + xMove[i];
                int nextY = temp.y + yMove[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
                    continue;
                if (board[nextX][nextY] == 1)
                    continue;

                int nextCost = temp.cost + 100;
                if (temp.dir != i)
                    nextCost += 500;

                if (dp[nextX][nextY][i] >= nextCost) {
                    dp[nextX][nextY][i] = nextCost;
                    q.add(new Node(nextX, nextY, i, nextCost));
                }
            }
        }

        return answer;
    }
}
