package CS;

import java.util.*;

public class Level3_26 {
    static boolean[][][] map;

    private static class Part implements Comparable<Part> {
        int x, y, type;

        public Part(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        @Override
        public int compareTo(Part o) {
            if (x != o.x)
                return x - o.x;
            else if (y != o.y)
                return y - o.y;
            else
                return type - o.type;
        }
    }

    public static void main(String[] args) {
        int[][] build_frame = { { 1, 0, 0, 1 }, { 2, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 } };
        int[][] result = solution(3, build_frame);
        for (int[] re : result)
            System.out.println(re[0] + "," + re[1] + "," + re[2]);
    }

    public static int[][] solution(int n, int[][] build_frame) {
        map = new boolean[n + 1][n + 1][2];
        List<Part> parts = new ArrayList<>();

        for (int[] b : build_frame) {
            int x = b[0], y = b[1], type = b[2], op = b[3];

            if (op == 1) {
                if (type == 0 && pillarCheck(x, y)) {
                    map[x][y][type] = true;
                    parts.add(new Part(x, y, type));
                } else if (type == 1 && floorCheck(x, y, n)) {
                    map[x][y][type] = true;
                    parts.add(new Part(x, y, type));
                }
            } else {
                map[x][y][type] = false;
                parts.removeIf(p -> p.x == x && p.y == y && p.type == type);
                if (!isValidAll(n, parts)) {
                    map[x][y][type] = true;
                    parts.add(new Part(x, y, type));
                }
            }
        }

        Collections.sort(parts);
        int[][] answer = new int[parts.size()][3];
        for (int i = 0; i < parts.size(); i++) {
            Part temp = parts.get(i);
            answer[i][0] = temp.x;
            answer[i][1] = temp.y;
            answer[i][2] = temp.type;
        }

        return answer;
    }

    // 구조물 제거 시 제거한 결과물 내 구성 구조물들이 조건을 만족하는지 재체크
    private static boolean isValidAll(int n, List<Part> parts) {
        for (Part p : parts) {
            if (p.type == 0 && !pillarCheck(p.x, p.y))
                return false;
            if (p.type == 1 && !floorCheck(p.x, p.y, n))
                return false;
        }
        return true;
    }

    // 기둥 적합도 체크
    // 바닥에 세워질 경우
    // 다른 기둥 위에 세워질 경우
    // 보의 우상단에 세워질 경우
    // 보의 좌상단에 세워질 경우
    private static boolean pillarCheck(int x, int y) {
        return y == 0
                || (y > 0 && map[x][y - 1][0])
                || (x > 0 && map[x - 1][y][1])
                || map[x][y][1];
    }

    // 보 적합도 체크
    // 좌측면이 기둥 위에 있을 경우
    // 우측면이 기둥 위에 있을 경우
    // 양측면에 보가 있을 경우
    private static boolean floorCheck(int x, int y, int n) {
        return (y > 0 && map[x][y - 1][0])
                || (x + 1 <= n && y > 0 && map[x + 1][y - 1][0])
                || (x > 0 && x + 1 <= n && map[x - 1][y][1] && map[x + 1][y][1]);
    }
}
