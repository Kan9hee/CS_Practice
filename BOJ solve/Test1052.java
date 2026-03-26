import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;
        while (countBottles(N) > M) {
            N++;
            answer++;
        }

        System.out.println(answer);
    }

    static int countBottles(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1)
                count++;
            n /= 2;
        }
        return count;
    }
}
