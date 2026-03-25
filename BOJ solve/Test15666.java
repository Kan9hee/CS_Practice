import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test15666 {
    static StringBuilder sb = new StringBuilder();
    static int[] vals, answerArray;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        vals = new int[N];
        answerArray = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            vals[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(vals);
        dfs(0, 0);

        System.out.println(sb);
    }

    static private void dfs(int num, int count) {
        if (count == M) {
            for (int i = 0; i < M; i++)
                sb.append(answerArray[i]).append(" ");
            sb.append("\n");
            return;
        }

        int temp = -1;
        for (int i = num; i < N; i++) {
            int next = vals[i];
            if (temp != next) {
                temp = next;
                answerArray[count] = vals[i];
                dfs(i, count + 1);
            }
        }
    }
}
