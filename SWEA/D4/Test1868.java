package SWEA.D4;

import java.io.*;
import java.util.*;

public class Test1868 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] moveX = { 0, 1, 1, 1, 0, -1, -1, -1 };
        int[] moveY = { 1, 1, 0, -1, -1, -1, 0, 1 };

        for (int test_case = 1; test_case <= T; test_case++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");

            int N = Integer.parseInt(br.readLine());
            char[][] map = new char[N][N];
            List<int[]> traps = new ArrayList<>();
            List<List<Integer>> nearPoints = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                nearPoints.add(new ArrayList<>());
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '*')
                        traps.add(new int[] { i, j });
                }
            }

            for (int[] point : traps) {
                for (int i = 0; i < 8; i++) {
                    int nearY = point[0] + moveY[i];
                    int nearX = point[1] + moveX[i];
                    if (nearX >= 0 && nearX < N && nearY >= 0 && nearY < N) {
                        if (map[nearY][nearX] == '*')
                            continue;
                        if (!nearPoints.get(nearY).contains(nearX))
                            nearPoints.get(nearY).add(nearX);
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '*' || nearPoints.get(i).contains(j))
                        continue;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] { i, j });
                    map[i][j] = '*';
                    while (!q.isEmpty()) {
                        int[] temp = q.poll();
                        for (int k = 0; k < 8; k++) {
                            int nextY = temp[0] + moveY[k];
                            int nextX = temp[1] + moveX[k];
                            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                                if (map[nextY][nextX] != '*') {
                                    map[nextY][nextX] = '*';
                                    if (nearPoints.get(nextY).contains(nextX)) {
                                        nearPoints.get(nextY).remove(Integer.valueOf(nextX));
                                        continue;
                                    }
                                    q.add(new int[] { nextY, nextX });
                                }
                            }
                        }
                    }
                    count++;
                }
            }

            for (List<Integer> points : nearPoints)
                count += points.size();

            sb.append(count);
            System.out.println(sb.toString());
        }

        br.close();
    }
}
