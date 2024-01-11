import java.io.*;

public class Test9466 {
    static int[] list;
    static boolean[] check;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            list = new int[n + 1];
            check = new boolean[n + 1];
            visited = new boolean[n + 1];
            answer = 0;

            String[] input = br.readLine().split("\\s+");
            for (int i = 0; i < n; i++)
                list[i + 1] = Integer.parseInt(input[i]);

            for (int i = 1; i <= n; i++)
                dfs(i);

            System.out.println(n - answer);
        }
    }

    private static void dfs(int num) {
        if (visited[num])
            return;

        visited[num] = true;
        if (!visited[list[num]])
            dfs(list[num]);
        else {
            if (!check[list[num]]) {
                answer++;
                for (int i = list[num]; i != num; i = list[i])
                    answer++;
            }
        }

        check[num] = true;
    }
}
