import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Test2668 {
    static ArrayList<Integer> list;
    static int[] num;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        num = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++)
            num[i] = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);
        sb.append(list.size() + "\n");
        for (int answer : list)
            sb.append(answer + "\n");

        System.out.println(sb);
    }

    private static void dfs(int current, int next) {
        if (!visited[num[current]]) {
            visited[num[current]] = true;
            dfs(num[current], next);
            visited[num[current]] = false;
        }
        if (num[current] == next)
            list.add(next);
    }
}
