import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJTest1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String base = br.readLine();
        for (char c : base.toCharArray())
            left.push(c);

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("L")) {
                if (!left.isEmpty())
                    right.push(left.pop());
            } else if (order.equals("D")) {
                if (!right.isEmpty())
                    left.push(right.pop());
            } else if (order.equals("B")) {
                if (!left.isEmpty())
                    left.pop();
            } else if (order.equals("P"))
                left.push(st.nextToken().charAt(0));
        }

        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty())
            right.push(left.pop());
        while (!right.isEmpty())
            sb.append(right.pop());

        System.out.println(sb);
    }
}
