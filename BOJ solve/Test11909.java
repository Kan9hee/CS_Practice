import java.util.*;

public class Test11909 {
    public static class Node {
        int count;
        int y;
        int x;

        public Node(int count, int y, int x) {
            this.count = count;
            this.y = y;
            this.x = x;
        }
    }

    static int[][] minimumMap;
    static int[][] A;
    static int[] xMove = new int[] { 0, 1 };
    static int[] yMove = new int[] { 1, 0 };
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        n = Integer.parseInt(sc.nextLine());
        A = new int[n + 1][n + 1];
        minimumMap = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(sc.nextLine());
            for (int j = 1; j <= n; j++) {
                minimumMap[i][j] = Integer.MAX_VALUE;
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        djikstra(1, 1);
        System.out.println(minimumMap[n][n]);
        sc.close();
    }

    public static void djikstra(int startX, int startY) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.count));
        pq.add(new Node(0, startX, startY));
        minimumMap[startY][startX] = 0;

        while (!pq.isEmpty()) {
            Node temp = pq.poll();

            for (int i = 0; i < 2; i++) {
                int nextX = temp.x + xMove[i];
                int nextY = temp.y + yMove[i];
                int nextCount = temp.count;

                if (nextX < startX || nextX > n || nextY < startY || nextY > n)
                    continue;
                if (A[nextY][nextX] >= A[temp.y][temp.x])
                    nextCount += (A[nextY][nextX] - A[temp.y][temp.x] + 1);
                if (nextCount >= minimumMap[nextY][nextX])
                    continue;

                minimumMap[nextY][nextX] = nextCount;
                pq.add(new Node(nextCount, nextY, nextX));
            }
        }
    }
}
