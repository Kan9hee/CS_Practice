import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        long[][] map = new long[N][21];

        String[] temp = br.readLine().split("\\s+");
        for (int i = 0; i < N; i++)
            list[i] = Integer.parseInt(temp[i]);

        map[0][list[0]] = 1;

        for (int idx = 1; idx < N; idx++) {
            for (int val = 0; val <= 20; val++) {
                if (map[idx - 1][val] != 0) {
                    if (val + list[idx] <= 20)
                        map[idx][val + list[idx]] += map[idx - 1][val];
                    if (val - list[idx] >= 0)
                        map[idx][val - list[idx]] += map[idx - 1][val];
                }
            }
        }

        System.out.println(map[N - 2][list[N - 1]]);
    }
}
