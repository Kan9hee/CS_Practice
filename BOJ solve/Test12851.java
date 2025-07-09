import java.io.*;
import java.util.*;

public class Test12851 {
    private static class Way {
        int count, location;

        public Way(int count, int location) {
            this.count = count;
            this.location = location;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);

        Queue<Way> q = new LinkedList<>();
        q.add(new Way(0, N));
        visited[N] = 0;
        int shortCase = Integer.MAX_VALUE;
        int results = 0;

        while (!q.isEmpty()) {
            Way temp = q.poll();

            if (temp.count > shortCase)
                continue;

            if (temp.location == K) {
                if (temp.count < shortCase) {
                    shortCase = temp.count;
                    results = 1;
                } else if (temp.count == shortCase) {
                    results++;
                }
                continue;
            }

            int nextCount = temp.count + 1;
            int[] nextLocations = { temp.location - 1, temp.location + 1, temp.location * 2 };
            for (int next : nextLocations) {
                if (next >= 0 && next <= 100000) {
                    if (visited[next] >= nextCount) {
                        visited[next] = nextCount;
                        q.add(new Way(nextCount, next));
                    }
                }
            }
        }

        System.out.println(shortCase + "\n" + results);
    }
}
