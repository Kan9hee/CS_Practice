import java.io.*;
import java.util.*;

public class Test1717 {
    static int[] sets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        sets = new int[n + 1];
        for (int i = 0; i <= n; i++)
            sets[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int aRoot = recursion(a);
            int bRoot = recursion(b);

            if (check == 0) {
                if (aRoot > bRoot)
                    sets[bRoot] = aRoot;
                else
                    sets[aRoot] = bRoot;
            } else {
                if (aRoot == bRoot)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    private static int recursion(int val) {
        if (sets[val] != val)
            sets[val] = recursion(sets[val]);
        return sets[val];
    }
}
