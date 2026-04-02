package CS;

public class Level2_34 {
    public static void main(String[] args) {
        int[] players = { 0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5 };
        System.out.println(solution(players, 3, 5));
    }

    public static int solution(int[] players, int m, int k) {
        int max = players.length;
        int answer = 0;

        int[] servers = new int[max];
        for (int i = 0; i < max; i++) {
            if (players[i] == 0)
                continue;
            int server = players[i] / m;
            if (servers[i] < server) {
                int val = server - servers[i];
                answer += val;
                for (int j = i; j < i + k; j++) {
                    if (j >= max)
                        break;
                    servers[j] += val;
                }
            }
        }

        return answer;
    }
}
