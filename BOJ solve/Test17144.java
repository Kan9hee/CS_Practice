import java.util.Scanner;
import java.util.StringTokenizer;

public class Test17144 {
    static int[][] map;
    static int[][] ways = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
    static int[] airPurifier = new int[2];
    static int r, c, t;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        int airPurifierCount = 0;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(sc.nextLine());
            for (int j = 0; j < c; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == -1) {
                    airPurifier[airPurifierCount] = i;
                    airPurifierCount++;
                }
                map[i][j] = val;
            }
        }

        for (int i = 0; i < t; i++) {
            map = spreadDust();
            purifyDust();
        }

        int result = 2;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result += map[i][j];
            }
        }

        System.out.println(result);
        sc.close();
    }

    static int[][] spreadDust() {
        int[][] afterSpread = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int spreadValue = map[i][j] / 5;
                int spreadCount = 0;
                if (spreadValue > 0) {
                    for (int k = 0; k < 4; k++) {
                        int yMove = i + ways[k][0];
                        int xMove = j + ways[k][1];
                        if (yMove >= 0 && xMove >= 0 && yMove < r && xMove < c) {
                            if (map[yMove][xMove] != -1) {
                                afterSpread[yMove][xMove] += spreadValue;
                                spreadCount++;
                            }
                        }
                    }
                }
                afterSpread[i][j] += map[i][j] - (spreadValue * spreadCount);
            }
        }

        return afterSpread;
    }

    static void purifyDust() {
        for (int x = airPurifier[0] - 1; x > 0; x--)
            map[x][0] = map[x - 1][0];
        for (int y = 0; y < c - 1; y++)
            map[0][y] = map[0][y + 1];
        for (int x = 0; x < airPurifier[0]; x++)
            map[x][c - 1] = map[x + 1][c - 1];
        for (int y = c - 1; y > 1; y--)
            map[airPurifier[0]][y] = map[airPurifier[0]][y - 1];

        map[airPurifier[0]][1] = 0;

        for (int x = airPurifier[1] + 1; x < r - 1; x++)
            map[x][0] = map[x + 1][0];
        for (int y = 0; y < c - 1; y++)
            map[r - 1][y] = map[r - 1][y + 1];
        for (int x = r - 1; x > airPurifier[1]; x--)
            map[x][c - 1] = map[x - 1][c - 1];
        for (int y = c - 1; y > 1; y--)
            map[airPurifier[1]][y] = map[airPurifier[1]][y - 1];

        map[airPurifier[1]][1] = 0;
    }
}
