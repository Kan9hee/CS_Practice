import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test21736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] xMove = new int[] { 1, 0, -1, 0 };
        int[] yMove = new int[] { 0, 1, 0, -1 };

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];

        int[] startPoint = new int[2];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'I') {
                    startPoint[0] = i;
                    startPoint[1] = j;
                    map[i][j] = 'X';
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(startPoint);

        int count = 0;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + yMove[i];
                int nextX = temp[1] + xMove[i];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && map[nextY][nextX] != 'X') {
                    if (map[nextY][nextX] == 'P')
                        count++;
                    map[nextY][nextX] = 'X';
                    q.add(new int[] { nextY, nextX });
                }
            }
        }

        if (count == 0)
            System.out.println("TT");
        else
            System.out.println(count);
    }
}
