package CS;

import java.util.Arrays;

public class Level2_23 {
    public static void main(String[] args) {
        System.out.println(solution(10, 40, 5));
    }

    public static int solution(int x, int y, int n) {
        int[] check = new int[y + 1];
        Arrays.fill(check, Integer.MAX_VALUE);

        check[x] = 0;

        for (int i = x; i <= y; i++) {
            if (check[i] == Integer.MAX_VALUE)
                continue;
            if (i + n <= y)
                check[i + n] = Math.min(check[i + n], check[i] + 1);
            if (i * 2 <= y)
                check[i * 2] = Math.min(check[i * 2], check[i] + 1);
            if (i * 3 <= y)
                check[i * 3] = Math.min(check[i * 3], check[i] + 1);
        }

        if (check[y] == Integer.MAX_VALUE)
            check[y] = -1;

        return check[y];
    }
}
