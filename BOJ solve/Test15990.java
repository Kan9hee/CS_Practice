import java.io.*;

public class Test15990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] list = new long[100001][4]; // 특정 값을 만들 때 해당 값으로 끝나는 경우
        list[1][1] = 1;
        list[2][2] = 1;
        list[3][1] = 1;
        list[3][2] = 1;
        list[3][3] = 1;
        for (int i = 4; i < 100001; i++) {
            list[i][1] = (list[i - 1][2] + list[i - 1][3]) % 1000000009;
            list[i][2] = (list[i - 2][1] + list[i - 2][3]) % 1000000009;
            list[i][3] = (list[i - 3][1] + list[i - 3][2]) % 1000000009;
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println((list[n][1] + list[n][2] + list[n][3]) % 1000000009);
        }
    }
}
