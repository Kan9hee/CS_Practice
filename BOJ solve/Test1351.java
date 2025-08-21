import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Test1351 {
    private static Map<Long, Long> dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());

        dp = new HashMap<>();
        dp.put(0L, 1L);

        System.out.println(recursion(n, p, q));
    }

    private static long recursion(long currentN, long p, long q) {
        if (dp.containsKey(currentN))
            return dp.get(currentN);

        long sum = recursion(currentN / p, p, q) + recursion(currentN / q, p, q);
        dp.put(currentN, sum);
        return sum;
    }
}
