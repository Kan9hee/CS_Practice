import java.io.*;

public class Test1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        double x = Double.parseDouble(input[0]);
        double y = Double.parseDouble(input[1]);
        int z = (int) (y * 100.0 / x);
        int answer = 0;

        if (z < 99) {
            for (;; x++, y++, answer++) {
                int newZ = (int) (y * 100.0 / x);
                if (newZ > z)
                    break;
                z = newZ;
            }
            System.out.println(answer);
        } else
            System.out.println(-1);
    }
}
