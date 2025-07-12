import java.io.*;
import java.util.*;

public class Test1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            pq.add(temp);
        }

        int answer = 0;
        while (true) {
            int temp1 = pq.poll();
            if (pq.size() <= 0)
                break;

            int temp2 = pq.poll();
            int sum = temp1 + temp2;
            answer += sum;
            pq.add(sum);
        }

        System.out.println(answer);
    }
}
