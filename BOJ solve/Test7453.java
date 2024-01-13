import java.io.*;
import java.util.*;

public class Test7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[4][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");
            map[0][i] = Integer.parseInt(input[0]);
            map[1][i] = Integer.parseInt(input[1]);
            map[2][i] = Integer.parseInt(input[2]);
            map[3][i] = Integer.parseInt(input[3]);
        }

        int[] ab = new int[n * n];
        int[] cd = new int[n * n];
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                ab[count] = map[0][i] + map[1][j];
                cd[count] = map[2][i] + map[3][j];
                count++;
            }

        Arrays.sort(ab);
        Arrays.sort(cd);

        long answer = 0;
        int l = 0, r = n * n - 1;
        while (l < n * n && r >= 0) {
            long abVal = ab[l], cdVal = cd[r];
            long sum = abVal + cdVal;
            if (sum > 0)
                r--;
            else if (sum < 0)
                l++;
            else {
                long lCount = 0, rCount = 0;
                while (l + lCount < n * n && abVal == ab[l]) {
                    lCount++;
                    l++;
                }
                while (r - rCount > 0 && cdVal == cd[r]) {
                    rCount++;
                    r--;
                }
                answer += lCount * rCount;
            }
        }

        System.out.println(answer);
    }
}
