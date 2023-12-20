import java.io.*;

public class Test8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            int answer = 0;
            for (int j = 0, count = 1; j < input.length; j++, count++) {
                if (input[j].equals("X"))
                    count = 0;
                answer += count;
            }
            System.out.println(answer);
        }
    }
}
