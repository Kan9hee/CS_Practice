import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1018 {
    public static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numLine = br.readLine().split(" ");

        int N = Integer.parseInt(numLine[0]);
        int M = Integer.parseInt(numLine[1]);

        map = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if (line[j].equals("W"))
                    map[i][j] = true;
                else
                    map[i][j] = false;
            }
        }

        int result = 64;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int count = 0;
                boolean TF = map[i][j];
                for (int x = i; x < i + 8; x++) {
                    for (int y = j; y < j + 8; y++) {
                        if (map[x][y] != TF)
                            count++;
                        TF = (!TF);
                    }
                    TF = !TF;
                }
                count = Math.min(count, 64 - count);
                result = Math.min(result, count);
            }
        }

        System.out.println(result);
    }
}
