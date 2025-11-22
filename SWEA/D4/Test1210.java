package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1210 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int T = 0; T < 10; T++) {
            int test_case = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");

            int[][] map = new int[100][100];
            int[] endPoint = new int[2];
            for (int i = 0; i < 100; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                    if (map[i][j] == 2) {
                        endPoint[0] = i;
                        endPoint[1] = j;
                    }
                }
            }

            int y = endPoint[0];
            int x = endPoint[1];

            while (y > 0) {
                if (x - 1 >= 0 && map[y][x - 1] == 1) {
                    while (x - 1 >= 0 && map[y][x - 1] == 1)
                        x--;
                    y--;
                } else if (x + 1 < 100 && map[y][x + 1] == 1) {
                    while (x + 1 < 100 && map[y][x + 1] == 1)
                        x++;
                    y--;
                } else
                    y--;
            }

            sb.append(x);
            System.out.println(sb.toString());
        }

        br.close();
    }
}
