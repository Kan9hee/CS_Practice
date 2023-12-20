import java.io.*;
import java.util.*;

public class Test15651 {
    static StringBuilder sb = new StringBuilder();
    static int[] list;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        list = new int[m];
        Arrays.fill(list, 1);
        find(0);
        System.out.print(sb);
    }

    private static void find(int count) {
        if (count == m) {
            sb.append(Arrays.toString(list).replaceAll("[\\[\\],]", ""));
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            list[count] = i;
            find(count + 1);
        }

        list[count] = 1;
    }
}
