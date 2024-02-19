import java.io.*;
import java.util.*;

public class Test1744 {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pls = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp > 0)
                pls.add(temp);
            else
                min.add(temp);
        }

        calcul(pls);
        calcul(min);

        System.out.println(answer);
    }

    private static void calcul(PriorityQueue<Integer> pq) {
        ArrayList<Integer> arr = new ArrayList<>();

        while (!pq.isEmpty()) {
            int temp = pq.poll();
            if (pq.isEmpty())
                arr.add(temp);
            else {
                int temp2 = pq.poll();
                if (temp == 1 || temp2 == 1) {
                    arr.add(temp);
                    arr.add(temp2);
                } else
                    arr.add(temp * temp2);
            }
        }

        for (int val : arr)
            answer += val;
    }
}
