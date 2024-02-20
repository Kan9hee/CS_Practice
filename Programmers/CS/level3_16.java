package CS;

import java.util.*;

public class level3_16 {

    public static void main(String[] args) {
        System.out.println(solution(5, 12));
    }

    public static int solution(int N, int number) {
        if (N == number)
            return 1;
        StringBuilder sb = new StringBuilder();

        ArrayList<HashSet<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= 8; i++)
            arr.add(new HashSet<>());
        arr.get(1).add(N);
        sb.append(N);

        for (int i = 2; i <= 8; i++) {
            sb.append(N);
            arr.get(i).add(Integer.parseInt(sb.toString()));
            for (int j = 1; j < i; j++) {
                int k = i - j;
                for (int n1 : arr.get(j)) {
                    for (int n2 : arr.get(k)) {
                        arr.get(i).add(n1 + n2);
                        arr.get(i).add(n1 - n2);
                        arr.get(i).add(n1 * n2);
                        if (n2 != 0)
                            arr.get(i).add(n1 / n2);
                    }
                }

                if (arr.get(i).contains(number))
                    return i;
            }
        }
        return -1;
    }
}
