import java.io.*;
import java.util.*;

public class Test2307 {
    static class Path {
        int end;
        int time;

        public Path(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }

    static ArrayList<Path>[] pathMap;
    static int[] disconnectList;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pathMap = new ArrayList[n + 1];
        disconnectList = new int[n + 1];
        for (int i = 1; i <= n; i++)
            pathMap[i] = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            pathMap[start].add(new Path(end, time));
            pathMap[end].add(new Path(start, time));
        }

        int answer = 0;
        int shortest = Dijkstra();

        for (int i = 2; i <= n; i++) {
            int result = disconnectedDijkstra(i);

            if (result == Integer.MAX_VALUE) {
                answer = -1;
                break;
            } else if (result - shortest > answer)
                answer = result - shortest;
        }

        System.out.println(answer);
        br.close();
    }

    static int Dijkstra() {
        PriorityQueue<Path> pq = new PriorityQueue<>((p1, p2) -> p1.time - p2.time);
        int times[] = new int[n + 1];
        for (int i = 2; i <= n; i++)
            times[i] = Integer.MAX_VALUE;

        pq.add(new Path(1, 0));
        while (!pq.isEmpty()) {
            Path temp = pq.poll();
            for (Path next : pathMap[temp.end]) {
                if (times[next.end] > times[temp.end] + next.time) {
                    times[next.end] = times[temp.end] + next.time;
                    disconnectList[next.end] = temp.end;
                    pq.add(new Path(next.end, times[next.end]));
                }
            }
        }

        return times[n];
    }

    static int disconnectedDijkstra(int nope) {
        PriorityQueue<Path> pq = new PriorityQueue<>((p1, p2) -> p1.time - p2.time);
        int times[] = new int[n + 1];
        for (int i = 2; i <= n; i++)
            times[i] = Integer.MAX_VALUE;

        pq.add(new Path(1, 0));
        while (!pq.isEmpty()) {
            Path temp = pq.poll();
            for (Path next : pathMap[temp.end]) {
                if ((temp.end == nope && next.end == disconnectList[nope])
                        || (temp.end == disconnectList[nope] && next.end == nope))
                    continue;

                if (times[next.end] > times[temp.end] + next.time) {
                    times[next.end] = times[temp.end] + next.time;
                    pq.add(new Path(next.end, times[next.end]));
                }
            }
        }

        return times[n];
    }
}
