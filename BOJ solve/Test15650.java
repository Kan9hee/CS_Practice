import java.io.*;

public class Test15650 {
    static int val, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        val = Integer.parseInt(input[0]);
        size = Integer.parseInt(input[1]);

        for (int i = 1; i <= val; i++)
            find(i, 1, Integer.toString(i));
    }

    private static void find(int num, int len, String array) {
        if (len == size) {
            System.out.println(array);
            return;
        }
        for (int i = num + 1; i <= val; i++)
            find(i, len + 1, array + " " + Integer.toString(i));
    }
}
