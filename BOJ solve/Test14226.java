import java.io.*;
import java.util.*;

public class Test14226 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] check = new boolean[n + 1][n + 1];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 1, 0, 0 });
        check[1][0] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (temp[0] == n) {
                System.out.println(temp[2]);
                break;
            }

            q.add(new int[] { temp[0], temp[0], temp[2] + 1 });

            if (temp[1] != 0 && temp[0] + temp[1] <= n && !check[temp[0] + temp[1]][temp[1]]) {
                check[temp[0] + temp[1]][temp[1]] = true;
                q.add(new int[] { temp[0] + temp[1], temp[1], temp[2] + 1 });
            }

            if (temp[0] > 0 && !check[temp[0] - 1][temp[1]]) {
                check[temp[0] - 1][temp[1]] = true;
                q.add(new int[] { temp[0] - 1, temp[1], temp[2] + 1 });
            }
        }
    }
}
