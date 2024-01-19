import java.io.*;
import java.util.*;

public class Test14586 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][2];
        int[] leftDominos = new int[n]; // 좌측으로 넘어가는 map의 도미노 위치들
        int[] rightDominos = new int[n]; // 우측으로 넘어가는 map의 도미노 위치들
        int[] ansDP = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");
            map[i][0] = Integer.parseInt(input[0]);
            map[i][1] = Integer.parseInt(input[1]);
        }
        Arrays.sort(map, (a, b) -> Integer.compare(a[0], b[0])); // 오름차순 정렬

        for (int i = 0; i < n; i++) {
            leftDominos[i] = i;
            rightDominos[i] = i;
            int tempL = map[i][0] - map[i][1];
            int tempR = map[i][0] + map[i][1];

            for (int j = i; j >= 0; j--) {
                // 좌측의 도미노가 넘어지는 범위 내에 있을 경우,
                // 그 다음으로 넘어질 수 있는 도미노의 범위를 갱신한 뒤
                // i번째 leftDominos의 값을 j와 비교해 더 작은 값으로 갱신한다.
                if (tempL <= map[j][0]) {
                    tempL = Math.min(tempL, map[j][0] - map[j][1]);
                    leftDominos[i] = Math.min(leftDominos[i], j);
                }
            }

            for (int j = i + 1; j < n; j++) {
                // 우측의 도미노가 넘어지는 범위 내에 있을 경우,
                // 그 다음으로 넘어질 수 있는 도미노의 범위를 갱신한 뒤
                // i번째 rightDominos의 값을 j와 비교해 더 작은 값으로 갱신한다.
                if (tempR >= map[j][0]) {
                    tempR = Math.max(tempR, map[j][0] + map[j][1]);
                    rightDominos[i] = Math.max(rightDominos[i], j);
                }
            }
        }

        Arrays.fill(ansDP, Integer.MAX_VALUE); // 최솟값 갱신을 위해 배열을 최대치로 채운다.
        ansDP[0] = 1; // 도미노는 무조건 한번은 넘어진다.

        for (int i = 0; i < n; i++) {
            // ansDP의 i번째 값을 갱신한다 == 도미노가 최소로 넘어진 횟수를 갱신한다.

            // leftDominos의 i번째 값이 유효할 경우, 현재 ansDP의 i번째 값과
            // ansDP의 '유효값-1'번째의 값 + 1을 비교해 더 작은 값으로 갱신한다.
            // leftDominos의 i번째 값이 유효하지 않을 경우, 1과 비교해 갱신한다.
            if (leftDominos[i] - 1 < 0)
                ansDP[i] = Math.min(ansDP[i], 1);
            else
                ansDP[i] = Math.min(ansDP[i], ansDP[leftDominos[i] - 1] + 1);

            // rightDominos의 j번째 값이 유효할 경우, 현재 ansDP의 i번째 값과
            // ansDP의 'j-1'번째의 값 + 1을 비교해 더 작은 값으로 갱신한다.
            // rightDominos의 j번째 값이 유효하지 않을 경우, 1과 비교해 갱신한다.
            for (int j = 0; j < i; j++) {
                if (rightDominos[j] >= i) {
                    if (j == 0)
                        ansDP[i] = Math.min(ansDP[i], 1);
                    else
                        ansDP[i] = Math.min(ansDP[i], ansDP[j - 1] + 1);
                }
            }
        }

        System.out.println(ansDP[n - 1]);
    }
}
