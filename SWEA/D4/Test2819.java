package SWEA.D4;

import java.io.*;
import java.util.*;

public class Test2819 {
    static int[] moveX = { 1, 0, 0, -1 };
    static int[] moveY = { 0, 1, -1, 0 };
    static String[][] map;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");

            map = new String[4][4];
            for (int i = 0; i < 4; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < 4; j++)
                    map[i][j] = line[j];
            }

            set = new HashSet<>();
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    dfs(i, j, 1, map[i][j]);

            sb.append(set.size());
            System.out.println(sb.toString());
        }

        br.close();
    }

    static void dfs(int y, int x, int count, String s) {
        if (count == 7) {
            set.add(s);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextY = y + moveY[i];
            int nextX = x + moveX[i];
            if (nextX >= 0 && nextX < 4 && nextY >= 0 && nextY < 4)
                dfs(nextY, nextX, count + 1, s + map[nextY][nextX]);
        }
    }
}
