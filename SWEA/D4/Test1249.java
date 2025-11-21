package SWEA.D4;

import java.io.*;
import java.util.*;

public class Test1249 {

    static class Node {
        int y, x, sum;

        public Node(int y, int x, int sum) {
            this.y = y;
            this.x = x;
            this.sum = sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] moveX = { 1, 0, 0, -1 };
        int[] moveY = { 0, 1, -1, 0 };

        for (int test_case = 1; test_case <= T; test_case++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");

            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            int[][] dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
                String line = br.readLine();
                for (int j = 0; j < N; j++)
                    map[i][j] = line.charAt(j) - '0';
            }

            PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.sum - n2.sum);
            pq.add(new Node(0, 0, map[0][0]));
            dist[0][0] = map[0][0];

            while (!pq.isEmpty()) {
                Node temp = pq.poll();

                if (temp.sum > dist[temp.y][temp.x])
                    continue;
                if (temp.x == N - 1 && temp.y == N - 1)
                    break;

                for (int i = 0; i < 4; i++) {
                    int nextY = temp.y + moveY[i];
                    int nextX = temp.x + moveX[i];
                    if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                        int nextSum = temp.sum + map[nextY][nextX];
                        if (nextSum < dist[nextY][nextX]) {
                            dist[nextY][nextX] = nextSum;
                            pq.add(new Node(nextY, nextX, nextSum));
                        }
                    }
                }
            }

            sb.append(dist[N - 1][N - 1]);
            System.out.println(sb.toString());
        }

        br.close();
    }
}
