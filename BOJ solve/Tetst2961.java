import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tetst2961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] sour = new int[N];
        int[] bitter = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, sour, bitter));
        br.close();
    }

    private static int solution(int N, int[] sour, int[] bitter) {
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i < (1 << N); i++) {
            int taste1 = 1;
            int taste2 = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    taste1 *= sour[j];
                    taste2 += bitter[j];
                }
            }
            int result = Math.abs(taste1 - taste2);
            answer = Math.min(answer, result);
        }

        return answer;
    }
}
