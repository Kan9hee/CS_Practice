import java.util.*;

public class Test2589 {
    static class Node {
        int count;
        int x;
        int y;

        public Node(int count, int x, int y) {
            this.count = count;
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] map;
    static int[] xMove = new int[] { 1, 0, -1, 0 };
    static int[] yMove = new int[] { 0, 1, 0, -1 };
    static int maxX, maxY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        Queue<Node> nodes = new LinkedList<>();

        maxY = Integer.parseInt(st.nextToken());
        maxX = Integer.parseInt(st.nextToken());
        map = new boolean[maxY][maxX];

        for (int i = 0; i < maxY; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < maxX; j++) {
                boolean mapping = line.charAt(j) == 'L';
                map[i][j] = mapping;
                if (mapping)
                    nodes.add(new Node(0, j, i));
            }
        }

        int answer = 0;
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            int currentMax = eachMaxCountFinder(node);
            answer = Integer.max(answer, currentMax);
        }

        System.out.println(answer);
    }

    static int eachMaxCountFinder(Node start) {
        Queue<Node> temps = new LinkedList<>();
        boolean[][] movedMap = new boolean[maxY][maxX];
        int result = 0;

        temps.add(start);
        movedMap[start.y][start.x] = true;

        while (!temps.isEmpty()) {
            Node temp = temps.poll();
            int currentCount = temp.count;
            result = Integer.max(result, currentCount);
            for (int i = 0; i < 4; i++) {
                int nextX = temp.x + xMove[i];
                int nextY = temp.y + yMove[i];
                if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY)
                    if (map[nextY][nextX] && !movedMap[nextY][nextX]) {
                        temps.add(new Node(currentCount + 1, nextX, nextY));
                        movedMap[nextY][nextX] = true;
                    }
            }
        }

        return result;
    }
}
