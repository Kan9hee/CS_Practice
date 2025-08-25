import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int left = max;
        int right = 10000 * 100000;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (m >= getCount(arr, mid)) {
                result = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }

        System.out.println(result);
    }

    private static int getCount(int[] arr, int val) {
        int count = 1;
        int money = val;

        for (int temp : arr) {
            money -= temp;
            if (money < 0) {
                count++;
                money = val - temp;
            }
        }

        return count;
    }
}
