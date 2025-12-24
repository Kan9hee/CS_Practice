import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Test11000 {
    static class Schedule {
        int start;
        int end;

        Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Schedule[] list = new Schedule[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[i] = new Schedule(start, end);
        }

        Arrays.sort(list, (l1, l2) -> l1.start == l2.start ? l1.end - l2.end : l1.start - l2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list[0].end);
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= list[i].start)
                pq.poll();
            pq.offer(list[i].end);
        }

        System.out.println(pq.size());
    }
}
