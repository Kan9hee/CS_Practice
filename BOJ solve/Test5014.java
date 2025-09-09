import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        boolean[] check = new boolean[f + 1];
        int[] stair = { s, 0 };
        check[s] = true;
        q.add(stair);

        int result = -1;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (temp[0] == g) {
                result = temp[1];
                break;
            }

            int nextUp = temp[0] + u;
            int nextDown = temp[0] - d;
            if (nextUp <= f && !check[nextUp]) {
                check[nextUp] = true;
                q.add(new int[] { nextUp, temp[1] + 1 });
            }
            if (nextDown > 0 && !check[nextDown]) {
                check[nextDown] = true;
                q.add(new int[] { nextDown, temp[1] + 1 });
            }
        }

        if (result > -1)
            System.out.println(result);
        else
            System.out.println("use the stairs");
    }
}
