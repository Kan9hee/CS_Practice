import java.io.*;
import java.util.*;

class Test7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] input = br.readLine().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            int[] A = new int[n];
            int[] B = new int[m];
            input = br.readLine().split("\\s+");
            for (int i = 0; i < n; i++)
                A[i] = Integer.parseInt(input[i]);
            input = br.readLine().split("\\s+");
            for (int i = 0; i < m; i++)
                B[i] = Integer.parseInt(input[i]);

            Arrays.sort(B);
            int answer = 0;
            for (int i = 0; i < n; i++) {
                int left = 0, right = m - 1;
                while (left < right) {
                    int middle = (left + right) / 2;
                    if (B[middle] >= A[i])
                        right = middle;
                    else
                        left = middle + 1;
                }
                if (left == m - 1)
                    left = A[i] > B[left] ? m : m - 1;
                answer += left;
            }

            System.out.println(answer);
        }
    }
}