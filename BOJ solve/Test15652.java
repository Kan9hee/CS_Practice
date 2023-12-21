import java.io.*;
import java.util.*;

public class Test15652 {
    static int[] list;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        list = new int[m];
        find(1, 0);
    }

    private static void find(int num, int count) {
        if (count == m) {
            StringBuilder sb = new StringBuilder();
            sb.append(Arrays.toString(list).replaceAll("[\\[\\],]", ""));
            System.out.println(sb);
            return;
        }
        for (int i = num; i <= n; i++) {
            list[count] = i;
            find(i, count + 1);
        }
    }
}