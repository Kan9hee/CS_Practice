import java.io.*;

public class Test1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int[] dp = new int[n];
        String[] input = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++)
            list[i] = Integer.parseInt(input[i]);

        int answer = 0;
        for (int i = 0; i < n; i++) { // 탐색범위 점진적 확장
            dp[i] = 1;
            // 현재 값(j번째)이 탐색범위 끝의 값보다 작거나
            // 현재 탐색(i번째) 결과가 이전 탐색 결과값+1보다 작을 경우
            // 현재 탐색값을 이전 탐색 결과값+1로 갱신한다.
            for (int j = 0; j < i; j++)
                if (list[j] < list[i] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}
