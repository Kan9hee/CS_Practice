import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] snacks = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            snacks[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(snacks);

        long left = 1;
        long right = snacks[n - 1];
        long reuslt = 0;

        while (left <= right) {
            int count = 0;
            long mid = (left + right) / 2;
            for (int i = 0; i < n; i++)
                count += snacks[i] / mid;
            if (count >= m) {
                if (reuslt < mid)
                    reuslt = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }

        System.out.println(reuslt);
    }
}
