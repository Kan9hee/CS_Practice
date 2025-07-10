import java.io.*;
import java.util.*;

public class Test11657 {
    private static class Way {
        int from, to, time;

        public Way(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Way> ways = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            ways.add(new Way(a, b, c));
        }

        long[] distances = new long[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[1] = 0;

        for (int i = 1; i < N; i++)
            for (Way w : ways)
                if (distances[w.from] != Integer.MAX_VALUE && distances[w.to] > distances[w.from] + w.time)
                    distances[w.to] = distances[w.from] + w.time;

        for (Way w : ways)
            if (distances[w.from] != Integer.MAX_VALUE && distances[w.to] > distances[w.from] + w.time) {
                System.out.println(-1);
                return;
            }

        for (int i = 2; i <= N; i++) {
            if (distances[i] == Integer.MAX_VALUE)
                distances[i] = -1;
            System.out.println(distances[i]);
        }
    }
}
