import java.io.*;
import java.util.*;

public class Test1865 {
    static class Info {
        int destination;
        int time;

        public Info(int destination, int time) {
            this.destination = destination;
            this.time = time;
        }
    }

    static ArrayList<ArrayList<Info>> Map;
    static StringTokenizer st;
    static int N, M, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (0 < testCase--) {
            Map = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N + 1; i++)
                Map.add(new ArrayList<>());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                Map.get(S).add(new Info(E, T));
                Map.get(E).add(new Info(S, T));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                Map.get(S).add(new Info(E, -T));
            }

            for (int i = 1; i <= N; i++) {
                if (bellmanFord(i)) {
                    System.out.println("YES");
                    break;
                }
                if (i == N)
                    System.out.println("NO");
            }
        }
    }

    static boolean bellmanFord(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 1; i < N; i++) {
            boolean stop = true;
            for (int j = 1; j <= N; j++) {
                for (Info temp : Map.get(j)) {
                    if (dist[j] != Integer.MAX_VALUE && dist[temp.destination] > dist[j] + temp.time) {
                        dist[temp.destination] = dist[j] + temp.time;
                        stop = false;
                    }
                }
            }
            if (stop)
                break;
        }

        for (int i = 1; i <= N; i++)
            for (Info temp : Map.get(i))
                if (dist[i] != Integer.MAX_VALUE && dist[temp.destination] > dist[i] + temp.time)
                    return true;

        return false;
    }
}