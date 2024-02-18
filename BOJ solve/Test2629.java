import java.io.*;

public class Test2629 {
    static boolean[][] check;
    static int[] list;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        check = new boolean[n + 1][40001];
        list = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            list[i] = Integer.parseInt(input[i]);

        adder(0, 0); // 재귀를 통해 모든 경우의 수를 구한다.

        int m = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int val = Integer.parseInt(input[i]);
            System.out.print(check[n][val] ? "Y " : "N "); // list의 모든 경우에 대해 한번씩 체크했으므로 n을 사용
        }
    }

    private static void adder(int count, int val) {
        if (check[count][val])
            return;
        check[count][val] = true;
        if (count == n)
            return;
        adder(count + 1, val);
        adder(count + 1, val + list[count]);
        adder(count + 1, Math.abs(val - list[count]));
    }
}
