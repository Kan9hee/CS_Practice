import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test14500 {
    private static boolean[][][] tetrominos = {
            { { true, true, true, true } },
            { { true }, { true }, { true }, { true } },

            { { true, true }, { true, true } },

            { { true, false }, { true, false }, { true, true } },
            { { true, true, true }, { true, false, false } },
            { { true, true }, { false, true }, { false, true } },
            { { false, false, true }, { true, true, true } },

            { { false, true }, { false, true }, { true, true } },
            { { true, false, false }, { true, true, true } },
            { { true, true }, { true, false }, { true, false } },
            { { true, true, true }, { false, false, true } },

            { { true, false }, { true, true }, { false, true } },
            { { false, true, true }, { true, true, false } },

            { { false, true }, { true, true }, { true, false } },
            { { true, true, false }, { false, true, true } },

            { { true, true, true }, { false, true, false } },
            { { false, true }, { true, true }, { false, true } },
            { { false, true, false }, { true, true, true } },
            { { true, false }, { true, true }, { true, false } }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (boolean[][] tetromino : tetrominos) {
            int ty = tetromino.length;
            int tx = tetromino[0].length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int maxCheckY = i + ty;
                    int maxCheckX = j + tx;
                    if (maxCheckY <= n && maxCheckX <= m) {
                        int currentVal = 0;
                        for (int ti = 0; ti < ty; ti++) {
                            for (int tj = 0; tj < tx; tj++)
                                if (tetromino[ti][tj])
                                    currentVal += map[i + ti][j + tj];
                        }
                        result = Math.max(result, currentVal);
                    }
                }
            }
        }

        System.out.println(result);
    }
}
