import java.io.*;

public class Test9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /*
         * int turn = n / 3;
         * int re = n % 3;
         * String answer;
         * if (turn % 2 == 0) {
         * if (re % 2 == 0)
         * answer = "CY";
         * else
         * answer = "SK";
         * } else {
         * if (re % 2 == 0)
         * answer = "SK";
         * else
         * answer = "CY";
         * }
         * System.out.println(answer);
         */
        System.out.println(n % 2 == 0 ? "CY" : "SK");
    }
}
