import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] sums = new long[N];
        long[] remainders = new long[M];

        st = new StringTokenizer(br.readLine());
        sums[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++)
            sums[i] = sums[i - 1] + Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int val = (int) (sums[i] % M);
            if (val == 0)
                answer++;
            remainders[val]++;
        }

        for (int i = 0; i < M; i++) {
            if (remainders[i] > 1)
                answer = answer + (remainders[i] * (remainders[i] - 1) / 2);
        }

        System.out.println(answer);
    }
}
