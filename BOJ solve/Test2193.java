import java.io.*;

public class Test2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] list = new long[n + 1];
        list[0] = 0;
        list[1] = 1;
        for (int i = 2; i <= n; i++)
            list[i] = list[i - 1] + list[i - 2];
        System.out.println(list[n]);
    }
}
