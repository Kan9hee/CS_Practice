import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Test2529 {
    static ArrayList<String> answers = new ArrayList<>();
    static int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    static String[] arr;
    static boolean[] visited;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        arr = new String[K];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++)
            arr[i] = st.nextToken();

        for (int i = 0; i < 10; i++) {
            visited = new boolean[10];
            visited[i] = true;
            find(i, 0, Integer.toString(i));
            visited[i] = false;
        }

        System.out.println(answers.get(answers.size() - 1));
        System.out.println(answers.get(0));
    }

    private static void find(int start, int count, String string) {
        if (string.length() == K + 1) {
            answers.add(string);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                String check = arr[count];
                if (check.equals(">")) {
                    if (start > i) {
                        visited[i] = true;
                        find(i, count + 1, string + i);
                        visited[i] = false;
                    }
                } else {
                    if (start < i) {
                        visited[i] = true;
                        find(i, count + 1, string + i);
                        visited[i] = false;
                    }
                }
            }
        }
    }
}
