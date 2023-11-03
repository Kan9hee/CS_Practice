import java.io.*;

public class Test18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int B = Integer.parseInt(input[2]);
        int[][] map = new int[N][M];

        int high = 0;
        int time = Integer.MAX_VALUE;
        int min = 256;
        int max = 0;

        for (int i = 0; i < N; i++) {
            input = br.readLine().split("\\s+");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (min > map[i][j])
                    min = map[i][j];
                if (max < map[i][j])
                    max = map[i][j];
            }

        }

        for (int start = min; start <= max; start++) {
            int count = 0;
            int inv = B;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (start < map[i][j]) {
                        count += ((map[i][j] - start) * 2);
                        inv += (map[i][j] - start);
                    } else {
                        count += (start - map[i][j]);
                        inv -= (start - map[i][j]);
                    }
                }
            }
            if (inv < 0)
                break;
            if (time >= count) {
                time = count;
                high = start;
            }
        }

        System.out.println(time + " " + high);
    }
}