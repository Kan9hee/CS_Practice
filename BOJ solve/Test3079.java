import java.io.*;
import java.util.*;

public class Test3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long result = Long.MAX_VALUE;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        long low = 0;
        long high = m * arr[n - 1];
        while (low <= high) {
            long temp = (low + high) / 2;
            long sum = 0;
            for (long index : arr) {
                long count = temp / index;
                if (sum < m)
                    sum += count;
            }
            if (sum >= m) {
                high = temp - 1;
                result = Math.min(temp, result);
            } else
                low = temp + 1;
        }

        System.out.println(result);
    }
}
