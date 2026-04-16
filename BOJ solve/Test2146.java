import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test2146 {
    static int[][] map;
    static int[] xMove = { -1, 0, 0, 1 };
    static int[] yMove = { 0, -1, 1, 0 };
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = map[i][j];
                if (num == 1) {
                    int result = find(i, j);
                    answer = Math.min(answer, result);
                    if (answer == 1) {
                        System.out.println(answer);
                        return;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static int find(int y, int x) {
        boolean[][] visited = new boolean[N][N];
        int result = Integer.MAX_VALUE;

        Queue<int[]> islandQ = new LinkedList<>();
        Queue<int[]> beachQ = new LinkedList<>();

        islandQ.add(new int[] { y, x });
        visited[y][x] = true;
        while (!islandQ.isEmpty()) {
            int[] temp = islandQ.poll();
            int currentY = temp[0];
            int currentX = temp[1];
            for (int i = 0; i < 4; i++) {
                int nextY = currentY + yMove[i];
                int nextX = currentX + xMove[i];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    if (!visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        if (map[nextY][nextX] == 0)
                            beachQ.add(new int[] { nextY, nextX, 1 });
                        else
                            islandQ.add(new int[] { nextY, nextX });
                    }
                }
            }
        }

        while (!beachQ.isEmpty()) {
            int[] temp = beachQ.poll();
            int currentY = temp[0];
            int currentX = temp[1];
            int currentNum = temp[2];
            for (int i = 0; i < 4; i++) {
                int nextY = currentY + yMove[i];
                int nextX = currentX + xMove[i];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    if (!visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        if (map[nextY][nextX] == 0)
                            beachQ.add(new int[] { nextY, nextX, currentNum + 1 });
                        else {
                            result = Math.min(result, currentNum);
                            if (result == 1)
                                return result;
                        }
                    }
                }
            }
        }

        return result;
    }
}
