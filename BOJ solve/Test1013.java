import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String pattern = "((100+1+)|(01))+";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            if (temp.matches(pattern))
                sb.append("YES");
            else
                sb.append("NO");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
