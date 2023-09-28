import java.io.*;
import java.util.*;

public class Test13549 {
    static class Node {
        int location;
        int time;

        Node(int location, int time) {
            this.location = location;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] family = br.readLine().split("\\s+");

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(Integer.parseInt(family[0]), 0));

        boolean[] check = new boolean[100001];
        int result = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.location == Integer.parseInt(family[1])) {
                result = Math.min(result, temp.time);
                continue;
            }
            if (temp.location >= 0 && temp.location <= 100000 && !check[temp.location]) {
                check[temp.location] = true;
                q.add(new Node(temp.location * 2, temp.time));
                q.add(new Node(temp.location - 1, temp.time + 1));
                q.add(new Node(temp.location + 1, temp.time + 1));
            }
        }

        System.out.println(result);
    }
}
