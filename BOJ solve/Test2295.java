import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Test2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        HashSet<Integer> sums = new HashSet<>();
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j < arr.length; j++)
                sums.add(arr[i] + arr[j]);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (sums.contains(arr[i] - arr[j])) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}
