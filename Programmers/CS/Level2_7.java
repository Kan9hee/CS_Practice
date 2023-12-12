package CS;
import java.util.LinkedList;
import java.util.Queue;

public class Level2_7 {
    static boolean[][] map;

    public static void main(String[] args) {
        int[][] wires = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };
        System.out.println(solution(9, wires));
    }

    public static int solution(int n, int[][] wires) {

        map = new boolean[n + 1][n + 1];
        int answer = n;

        for (int i = 0; i < wires.length; i++) {
            map[wires[i][0]][wires[i][1]] = true;
            map[wires[i][1]][wires[i][0]] = true;
        }

        for (int i = 0; i < wires.length; i++) {
            int temp1 = wires[i][0], temp2 = wires[i][1];
            map[temp1][temp2] = map[temp2][temp1] = false;
            answer = Math.min(answer, BFS(n, temp1));
            map[temp1][temp2] = map[temp2][temp1] = true;
        }

        return answer;
    }

    private static int BFS(int n, int point) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[n + 1];
        int count = 1;
        q.add(point);

        while (!q.isEmpty()) {
            int temp = q.poll();
            check[temp] = true;
            for (int i = 1; i <= n; i++) {
                if (check[i])
                    continue;
                if (map[temp][i]) {
                    q.add(i);
                    count++;
                }
            }
        }

        return Math.abs(count * 2 - n);
    }
}
