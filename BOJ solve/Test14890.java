import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test14890 {
    static int[][] board;
    static int n, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (rowCheck(i))
                count++;
            if (colCheck(i))
                count++;
        }

        System.out.println(count);
    }

    private static boolean rowCheck(int num) {
        boolean[] inclineCheck = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = board[num][i] - board[num][i + 1];

            if (diff > 1 || diff < -1)
                return false;
            else if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || inclineCheck[i - j])
                        return false;
                    if (board[num][i] != board[num][i - j])
                        return false;
                    inclineCheck[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || inclineCheck[i + j])
                        return false;
                    if (board[num][i] - 1 != board[num][i + j])
                        return false;
                    inclineCheck[i + j] = true;
                }
            }
        }

        return true;
    }

    private static boolean colCheck(int num) {
        boolean[] inclineCheck = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = board[i][num] - board[i + 1][num];

            if (diff > 1 || diff < -1)
                return false;
            else if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || inclineCheck[i - j])
                        return false;
                    if (board[i][num] != board[i - j][num])
                        return false;
                    inclineCheck[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || inclineCheck[i + j])
                        return false;
                    if (board[i][num] - 1 != board[i + j][num])
                        return false;
                    inclineCheck[i + j] = true;
                }
            }
        }

        return true;
    }
}
