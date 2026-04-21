import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Test17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> map = new HashMap<>(st.countTokens());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            String temp = st.nextToken();
            arr[i] = temp;
            if (map.containsKey(temp)) {
                int val = map.get(temp);
                map.replace(temp, val + 1);
            } else
                map.put(temp, 1);
        }

        String[] result = new String[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && map.get(arr[stack.peek()]) < map.get(arr[i])) {
                int prevIndex = stack.pop();
                result[prevIndex] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty())
            result[stack.pop()] = "-1";

        StringBuilder sb = new StringBuilder();
        for (String r : result)
            sb.append(r).append(" ");

        System.out.println(sb.toString());
    }
}
