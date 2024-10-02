import java.io.*;
import java.util.*;

public class Test1655 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> leftPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightPQ = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            if (leftPQ.isEmpty() || leftPQ.peek() >= val)
                leftPQ.add(val);
            else
                rightPQ.add(val);

            if (leftPQ.size() < rightPQ.size())
                leftPQ.add(rightPQ.poll());
            else if (leftPQ.size() > rightPQ.size() + 1)
                rightPQ.add(leftPQ.poll());

            sb.append(leftPQ.peek() + "\n");
        }

        System.out.println(sb);
    }
}
