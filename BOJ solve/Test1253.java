import java.io.*;
import java.util.Arrays;

public class Test1253 {
    static long[] list;
    static int result = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new long[N];

        String[] input = br.readLine().split("\\s+");
        for (int i = 0; i < N; i++)
            list[i] = Integer.parseInt(input[i]);

        Arrays.sort(list);
        for (int i = 0; i < N; i++)
            search(i);

        System.out.println(result);
    }

    private static void search(int val) {
        int start = 0, end = N - 1;
        if (val == start)
            start++;
        else if (val == end)
            end--;

        while (start != end) {
            if (list[val] == (list[start] + list[end])) {
                result++;
                break;
            }

            if (list[val] < (list[start] + list[end]))
                end--;
            else
                start++;

            if (val == start)
                start++;
            else if (val == end)
                end--;
        }
    }
}
