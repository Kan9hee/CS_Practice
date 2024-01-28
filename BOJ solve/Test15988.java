import java.io.*;

public class Test15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int size = n > 3 ? n + 1 : 4;
            long[] list = new long[size];
            list[1] = 1;
            list[2] = 2;
            list[3] = 4;
            for (int i = 4; i <= n; i++)
                list[i] = (list[i - 3] + list[i - 2] + list[i - 1]) % 1000000009;
            System.out.println(list[n]);
        }
    }
}
