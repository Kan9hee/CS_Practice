import java.io.*;

public class Test1904 {
    static Integer[] list = new Integer[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list[0] = 0;
        list[1] = 1;
        list[2] = 2;
        System.out.println(find(n));
    }

    private static Integer find(int val) {
        if (list[val] == null)
            list[val] = (find(val - 1) + find(val - 2)) % 15746;

        return list[val];
    }
}
