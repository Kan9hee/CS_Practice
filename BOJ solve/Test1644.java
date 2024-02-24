import java.io.*;
import java.util.*;

public class Test1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1)
            System.out.println(0);
        else if (n > 1 && n < 4)
            System.out.println(1);
        else {
            ArrayList<Integer> arr = new ArrayList<>();
            boolean[] check = new boolean[n + 1];

            for (int i = 2; i * i <= n; i++)
                if (!check[i])
                    for (int j = i * i; j <= n; j += i)
                        check[j] = true;

            for (int i = 2; i <= n; i++)
                if (!check[i])
                    arr.add(i);

            int len = arr.size();
            int answer = 0, left = 0, right = 0;
            while (true) {
                if (left == len || right == len || left > right)
                    break;
                int sum = 0;
                for (int i = left; i <= right; i++)
                    sum += arr.get(i);
                if (sum > n)
                    left++;
                else if (sum < n)
                    right++;
                else {
                    answer++;
                    right++;
                }
            }

            System.out.println(answer);
        }
    }
}
