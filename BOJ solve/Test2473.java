import java.io.*;
import java.util.*;

public class Test2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] list = new int[n];
        String[] input = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++)
            list[i] = Integer.parseInt(input[i]);
        Arrays.sort(list);

        long min = Long.MAX_VALUE;
        int low = 0, mid = 0, top = 0;

        for (int i = 0; i < n - 2; i++) {
            int m = i + 1;
            int r = n - 1;
            while (m < r) {
                long sum = (long) list[i] + list[m] + list[r];
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    low = i;
                    mid = m;
                    top = r;
                }
                if (sum == 0) {
                    low = i;
                    mid = m;
                    top = r;
                    break;
                } else if (sum > 0)
                    r--;
                else
                    m++;
            }
        }

        System.out.println(list[low] + " " + list[mid] + " " + list[top]);
    }
}
