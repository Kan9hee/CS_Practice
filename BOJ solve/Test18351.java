import java.io.*;
import java.util.*;

public class Test18351 {
    static ArrayList<Integer>[] map;
    static int[] xMove = { 1, 0, -1, 0 };
    static int[] yMove = { 0, 1, 0, -1 };
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        int x = Integer.parseInt(input[3]);

        map = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            map[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            input = br.readLine().split("\\s+");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            map[start].add(end);
        }

        BFS(x);
    }

    private static void BFS(int start) {
        int[] list = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        Arrays.fill(list, -1);
        list[start] = 0;

        ArrayList<Integer> answerList = new ArrayList<>();

        while (!q.isEmpty()) {
            int temp = q.poll();
            if (list[temp] == k)
                answerList.add(temp);
            else if (list[temp] > k)
                break;
            for (int next : map[temp]) {
                if (list[next] != -1)
                    continue;
                list[next] = list[temp] + 1;
                q.add(next);
            }
        }

        Collections.sort(answerList);
        for (int val : answerList)
            sb.append(val + "\n");

        System.out.println(answerList.isEmpty() ? -1 : sb);
    }
}
