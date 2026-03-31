package CS;

import java.util.LinkedList;
import java.util.Queue;

public class Level2_33 {
    public static void main(String[] args) {
        int[][] points = { { 3, 2 }, { 6, 4 }, { 4, 7 }, { 1, 4 } };
        int[][] routes = { { 4, 2 }, { 1, 3 }, { 2, 4 } };
        System.out.println(solution(points, routes));
    }

    public static int solution(int[][] points, int[][] routes) {
        Queue<int[]>[] record = new LinkedList[routes.length];
        int answer = 0;

        for (int i = 0; i < routes.length; i++)
            record[i] = new LinkedList<>();

        for (int i = 0; i < routes.length; i++) {
            int start_index = routes[i][0] - 1;
            int[] start = points[start_index].clone();
            record[i].add(new int[] { start[0], start[1] });
            for (int j = 1; j < routes[i].length; j++) {
                int temp_index = routes[i][j] - 1;
                int[] temp = points[temp_index];
                while (start[0] != temp[0]) {
                    if (start[0] < temp[0])
                        start[0]++;
                    else
                        start[0]--;
                    record[i].add(new int[] { start[0], start[1] });
                }
                while (start[1] != temp[1]) {
                    if (start[1] < temp[1])
                        start[1]++;
                    else
                        start[1]--;
                    record[i].add(new int[] { start[0], start[1] });
                }
            }
        }

        int esacpe_count = 0;

        while (esacpe_count != routes.length) {
            int[][] map = new int[101][101];
            esacpe_count = 0;
            for (int i = 0; i < routes.length; i++) {
                if (record[i].isEmpty()) {
                    esacpe_count++;
                    continue;
                }
                int[] fails = record[i].poll();
                map[fails[0]][fails[1]]++;
            }
            for (int i = 0; i <= 100; i++)
                for (int j = 0; j <= 100; j++)
                    if (map[i][j] > 1)
                        answer++;
        }

        return answer;
    }
}
