import java.io.*;
import java.util.*;

public class Test2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] lowCases = new int[n + 1];
        for (int i = 0; i <= n; i++)
            arr.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            arr.get(a).add(b);
            lowCases[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            if (lowCases[i] == 0)
                q.add(i);

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int temp = q.poll();
            sb.append(temp).append(" ");
            for (int i = 0; i < arr.get(temp).size(); i++) {
                lowCases[arr.get(temp).get(i)]--;
                if (lowCases[arr.get(temp).get(i)] == 0)
                    q.add(arr.get(temp).get(i));
            }
        }

        System.out.println(sb.toString());
    }
}
