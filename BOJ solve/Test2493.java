import java.io.*;
import java.util.*;

public class Test2493 {
    private static class Tower {
        int index, height;

        public Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] towerHeights = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            towerHeights[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        Stack<Tower> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            while (!stack.isEmpty() && stack.peek().height < towerHeights[i])
                stack.pop();

            if (stack.isEmpty())
                sb.append("0 ");
            else
                sb.append(stack.peek().index).append(" ");

            stack.push(new Tower(i, towerHeights[i]));
        }

        System.out.println(sb.toString());
    }
}
