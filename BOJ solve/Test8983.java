import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test8983 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] shootPoints = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            shootPoints[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(shootPoints);
        int result = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());
            if (check(shootPoints, m, l, targetX, targetY))
                result++;
        }

        System.out.println(result);
    }

    private static boolean check(int[] shootPoints, int m, int l, int x, int y) {
        int start = 0;
        int end = m - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int distance = Math.abs(x - shootPoints[mid]) + y;

            if (distance <= l)
                return true;
            if (x == shootPoints[mid])
                return false;

            if (x < shootPoints[mid])
                end = mid - 1;
            else if (x > shootPoints[mid])
                start = mid + 1;
        }

        return false;
    }
}
