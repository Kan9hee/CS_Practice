import java.io.*;

public class Test2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        int[][][] status = new int[t + 1][3][w + 1]; // 시간,위치,이동횟수
        int[] list = new int[t + 1];

        for (int i = 1; i <= t; i++)
            list[i] = Integer.parseInt(br.readLine());

        // 초기값 설정(처음 위치는 1이라 가정)
        if (list[1] == 1) {
            status[1][1][0] = 1;
            status[1][2][1] = 0;
        } else {
            status[1][1][0] = 0;
            status[1][2][1] = 1;
        }

        for (int i = 2; i <= t; i++) {
            // 현재 위치가 1일 경우
            if (list[i] == 1) {
                // 이동횟수 0번
                status[i][1][0] = status[i - 1][1][0] + 1;
                status[i][2][0] = status[i - 1][2][0];
                // 이동횟수 1번 이상
                // 현재 위치의 이전 시간의 값과, 반대 위치의 이전시간에서 1번 적은 이동횟수의 값을 비교
                // 반대 위치에서 현재 위치로 올 경우 이동횟수가 증가하므로 이전 시간대 비교시 이동횟수가 1번 적은 경우를 이용한다.
                for (int j = 1; j <= w; j++) {
                    status[i][1][j] = Math.max(status[i - 1][1][j], status[i - 1][2][j - 1]) + 1;
                    status[i][2][j] = Math.max(status[i - 1][1][j - 1], status[i - 1][2][j]);
                }
            }
            // 현재 위치가 2일 경우
            else {
                // 이동횟수 0번
                status[i][1][0] = status[i - 1][1][0];
                status[i][2][0] = status[i - 1][2][0] + 1;
                // 이동횟수 1번 이상
                for (int j = 1; j <= w; j++) {
                    status[i][1][j] = Math.max(status[i - 1][1][j], status[i - 1][2][j - 1]);
                    status[i][2][j] = Math.max(status[i - 1][1][j - 1], status[i - 1][2][j]) + 1;
                }
            }
        }

        int answer = 0;
        // 최종 시간대에서 모든 위치에 대해 모든 이동횟수에 해당하는 값을 비교
        for (int i = 0; i <= w; i++)
            answer = Math.max(answer, Math.max(status[t][1][i], status[t][2][i]));
        System.out.println(answer);
    }
}
