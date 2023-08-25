import java.util.*;

class Piece {
    int[][] shape = new int[6][2];
    int count;
}

public class Level3_14 {
    static int[] moveX = { -1, 0, 0, 1 };
    static int[] moveY = { 0, -1, 1, 0 };

    public static void main(String[] args) {
        int[][] game_board = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 1 } };
        int[][] table = { { 1, 1, 1 }, { 1, 0, 0 }, { 0, 0, 0 } };
        System.out.println(solution(game_board, table));
    }

    public static int solution(int[][] game_board, int[][] table) {
        ArrayList<Piece> stuff = new ArrayList<>();
        ArrayList<Piece> blanks = new ArrayList<>();
        int answer = 0;

        find(table, stuff, 1, 0);
        find(game_board, blanks, 0, 1);

        for (Piece blank : blanks) {
            for (Piece object : stuff) {
                if (checkInsert(object, blank)) {
                    answer += object.count;
                    stuff.remove(object);
                    if (stuff.size() == 0)
                        return answer;
                    break;
                }
            }
        }
        return answer;
    }

    private static void find(int[][] map, List<Piece> list, int yes, int no) {
        int n = map.length;
        int m = map[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == yes)
                    list.add(BFC(map, n, m, new int[] { i, j }, yes, no));
            }
        }
    }

    private static Piece BFC(int[][] map, int lenX, int lenY, int[] start, int yes, int no) {
        Piece piece = new Piece();
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        map[start[0]][start[1]] = no;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            piece.shape[piece.count++] = now;
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + moveX[i];
                int nextY = now[1] + moveY[i];
                if (nextX < 0 || nextX >= lenX || nextY < 0 || nextY >= lenY || map[nextX][nextY] == no)
                    continue;
                map[nextX][nextY] = no;
                q.add(new int[] { nextX, nextY });
            }
        }

        setPiece(piece);
        return piece;
    }

    public static void setPiece(Piece piece) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int i = 0; i < piece.count; i++) {
            if (piece.shape[i][0] < minX) {
                minX = piece.shape[i][0];
                minY = piece.shape[i][1];
            } else if (piece.shape[i][0] == minX && piece.shape[i][1] < minY) {
                minY = piece.shape[i][1];
            }
        }

        for (int i = 0; i < piece.count; i++) {
            piece.shape[i][0] -= minX;
            piece.shape[i][1] -= minY;
        }
    }

    public static boolean checkInsert(Piece object, Piece blank) {
        if (object.count != blank.count)
            return false;
        int size = object.count;

        for (int i = 0; i < 3; i++) {
            if (isSameShape(size, object.shape, blank.shape))
                return true;
            turn(object);
        }

        if (isSameShape(size, object.shape, blank.shape))
            return true;
        return false;
    }

    public static boolean isSameShape(int size, int[][] shape1, int[][] shape2) {
        for (int j = 0; j < size; j++) {
            int k = 0;
            for (; k < size; k++) {
                if (shape1[j][0] == shape2[k][0] && shape1[j][1] == shape2[k][1])
                    break;
            }
            if (k == size)
                return false;
        }
        return true;
    }

    public static void turn(Piece piece) {
        for (int i = 0; i < piece.count; i++) {
            int temp = -piece.shape[i][0];
            piece.shape[i][0] = piece.shape[i][1];
            piece.shape[i][1] = temp;
        }
        setPiece(piece);
    }
}
