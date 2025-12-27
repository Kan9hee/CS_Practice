import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N2 = 123456 * 2;
        boolean[] check = new boolean[N2 + 1];
        Arrays.fill(check, true);
        check[0] = false;
        check[1] = false;

        for (int i = 2; i <= Math.sqrt(N2); i++) {
            if (check[i]) {
                for (int j = i * i; j <= N2; j += i)
                    check[j] = false;
            }
        }

        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0)
                break;
            int count = 0;
            for (int i = input + 1; i <= input * 2; i++)
                if (check[i])
                    count++;
            sb.append(count).append("\n");
        }

        System.out.println(sb.toString());
    }
}
