package CS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Level3_20 {
    public static void main(String[] args) {
        int[][] maps = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 },
                { 1, 2 }, { 2, 4 }, { 5, 2 } };
        System.out.println(solution(6, maps));
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0, depth = 0;
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        boolean[] check = new boolean[n + 1];
        check[1] = true;

        for (int i = 0; i <= n; i++)
            map.add(new ArrayList<>());

        for (int[] e : edge) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 1, 0 });
        while (!q.isEmpty()) {
            int temp[] = q.poll();
            if (depth == temp[1])
                answer++;
            else if (depth < temp[1]) {
                depth = temp[1];
                answer = 1;
            }
            for (int next : map.get(temp[0])) {
                if (!check[next]) {
                    check[next] = true;
                    q.add(new int[] { next, temp[1] + 1 });
                }
            }
        }

        return answer;
    }
}
