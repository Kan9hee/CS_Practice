package CS;
import java.util.*;

public class Level3_6 {
    static boolean[] visited;
    static ArrayList<String> wayList;

    public static void main(String[] args) {
        String[][] tickets = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
        solution(tickets);
    }

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        wayList = new ArrayList<>();

        DFS("ICN", "ICN", tickets, 0);
        Collections.sort(wayList);
        return wayList.get(0).split(" ");
    }

    public static void DFS(String start, String route, String[][] tickets, int count) {
        if (count == tickets.length) {
            wayList.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                DFS(tickets[i][1], route + " " + tickets[i][1], tickets, count + 1);
                visited[i] = false;
            }
        }
    }
}
