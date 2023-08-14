import java.util.*;

public class Level3_7 {
    public static void main(String[] args) {
        int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        solution(3, computers);
    }

    public static int solution(int n, int[][] computers) {
        boolean[] check = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                BFS(computers, i, check);
                answer++;
            }
        }

        return answer;
    }

    private static void BFS(int[][] computers, int start, boolean[] check) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        check[start] = true;

        while (!queue.isEmpty()) {
            int comNum = queue.poll();
            for (int i = 0; i < computers.length; i++) {
                if (computers[comNum][i] == 1 && !check[i]) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
