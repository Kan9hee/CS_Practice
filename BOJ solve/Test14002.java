import java.io.*;

public class Test14002 {
    static int[] list, dpList;
    static int n, count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        dpList = new int[n];
        String[] input = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++)
            list[i] = Integer.parseInt(input[i]);

        int count = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--)
                if (list[j] < list[i] && dpList[j] > max)
                    max = dpList[j];
            dpList[i] = max + 1;
            count = Math.max(count, dpList[i]);
        }

        System.out.println(count);

        int[] answer = new int[count];
        for (int i = n - 1; i >= 0 && count > 0; i--) {
            if (dpList[i] == count) {
                answer[count - 1] = list[i];
                count--;
            }
        }

        for (int val : answer)
            System.out.print(val + " ");
    }
}