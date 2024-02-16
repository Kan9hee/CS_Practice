import java.io.*;
import java.util.*;

public class Test2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] list1 = new int[N];
            String[] input = br.readLine().split("\\s+");
            for (int i = 0; i < N; i++)
                list1[i] = Integer.parseInt(input[i]);

            Arrays.sort(list1);

            int M = Integer.parseInt(br.readLine());
            int[] list2 = new int[M];
            input = br.readLine().split("\\s+");
            for (int i = 0; i < M; i++)
                list2[i] = Integer.parseInt(input[i]);

            for (int i = 0; i < M; i++) {
                int left = 0, right = N - 1;
                boolean isContain = false;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (list1[mid] == list2[i]) {
                        isContain = true;
                        break;
                    } else if (list1[mid] > list2[i])
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
                sb.append(isContain ? 1 : 0).append("\n");
            }
        }

        System.out.println(sb);
    }
}
