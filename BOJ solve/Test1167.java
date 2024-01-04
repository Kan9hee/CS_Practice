import java.io.*;
import java.util.*;

public class Test1167 {
    static class Node {
        int end, val;

        public Node(int end, int val) {
            this.end = end;
            this.val = val;
        }
    }

    static ArrayList<Node>[] map;
    static boolean[] check;
    static int v, farNum, maxVal = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        map = new ArrayList[v + 1];

        for (int i = 1; i <= v; i++)
            map[i] = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            String[] input = br.readLine().split("\\s+");
            int start = Integer.parseInt(input[0]);
            for (int j = 1; j < input.length - 2; j += 2) {
                int end = Integer.parseInt(input[j]);
                int val = Integer.parseInt(input[j + 1]);
                map[start].add(new Node(end, val));
            }
        }

        check = new boolean[v + 1];
        check[1] = true;
        dfs(1, 0);

        check = new boolean[v + 1];
        check[farNum] = true;
        dfs(farNum, 0);

        System.out.println(maxVal);
    }

    private static void dfs(int num, int sum) {
        if (sum > maxVal) {
            maxVal = sum;
            farNum = num;
        }
        for (Node next : map[num]) {
            if (!check[next.end]) {
                check[next.end] = true;
                dfs(next.end, sum + next.val);
            }
        }
    }
}
