import java.io.*;
import java.util.*;

public class Test1766 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] cases;
    static int[] laterCounts;
    static int N, M;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cases = new ArrayList[N + 1];
        laterCounts = new int[N + 1];
        for (int i = 1; i <= N; i++)
            cases[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            cases[A].add(B);
            laterCounts[B]++;
        }

        changePriority();
        System.out.println(sb.toString());
    }

    private static void changePriority() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++)
            if (laterCounts[i] == 0)
                pq.add(i);

        while (!pq.isEmpty()) {
            int val = pq.poll();
            sb.append(val).append(" ");
            for (int next : cases[val]) {
                laterCounts[next]--;
                if (laterCounts[next] == 0)
                    pq.add(next);
            }
        }
    }
}
