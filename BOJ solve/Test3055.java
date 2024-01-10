import java.io.*;
import java.util.*;

public class Test3055 {
    static class Info {
        int x, y;
        String status;

        public Info(int x, int y, String status) {
            this.x = x;
            this.y = y;
            this.status = status;
        }
    }

    static Queue<Info> q = new LinkedList<>();
    static String[][] map;
    static int[][] dp;
    static int[] xmove = new int[] { 1, 0, -1, 0 };
    static int[] ymove = new int[] { 0, 1, 0, -1 };
    static Info hedgehog;
    static Info beaver;
    static int r, c, currentLevel = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        map = new String[r][c];
        dp = new int[r][c];
        for (int i = 0; i < r; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                if (input[j].equals("*"))
                    q.add(new Info(i, j, input[j]));
                else if (input[j].equals("D"))
                    beaver = new Info(i, j, input[j]);
                else if (input[j].equals("S")) {
                    hedgehog = new Info(i, j, input[j]);
                    input[j] = ".";
                }
                map[i][j] = input[j];
            }
        }

        q.add(hedgehog);
        hedgehogMove();
    }

    private static void hedgehogMove() {
        while (!q.isEmpty()) {
            Info temp = q.poll();
            if (temp.x == beaver.x && temp.y == beaver.y) {
                System.out.println(dp[temp.x][temp.y]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + xmove[i];
                int ny = temp.y + ymove[i];
                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    if (temp.status.equals("*")) {
                        if (map[nx][ny].equals(".") || map[nx][ny].equals(",")) {
                            map[nx][ny] = "*";
                            q.add(new Info(nx, ny, temp.status));
                        }
                    } else if (map[nx][ny].equals(".") || map[nx][ny].equals("D")) {
                        map[nx][ny] = ",";
                        dp[nx][ny] = dp[temp.x][temp.y] + 1;
                        q.add(new Info(nx, ny, temp.status));
                    }
                }
            }
        }
        System.out.println("KAKTUS");
    }
}
