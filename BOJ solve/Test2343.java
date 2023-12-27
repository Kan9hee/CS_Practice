import java.io.*;
import java.util.*;

public class Test2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] list = new int[n];

        int l = 0, r = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            r += list[i];
            l = Math.max(l, list[i]);
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            int count = 0;
            for (int i = 0, sum = 0; i < n; i++) {
                if (sum + list[i] > mid) {
                    sum = 0;
                    count++;
                }
                sum += list[i];
                if (i + 1 == n && sum > 0)
                    count++;
            }
            if (count > m)
                l = mid + 1;
            else
                r = mid - 1;
        }

        System.out.println(l);
    }
}
