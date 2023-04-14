import java.util.*;

public class Level2_3 {

    static char[][] maze;
    static boolean[][] visited;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        String[] maps = { "SELOX", "XXXXO", "OOOOO", "OXXXX", "OOOOO", "OOOOO" };
        System.out.println(solution(maps));
    }

    public static int solution(String[] maps) {
        maze = new char[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] lever = new int[2];

        for (int Y = 0; Y < maps.length; Y++) {
            maze[Y] = maps[Y].toCharArray();
            for (int X = 0; X < maze[Y].length; X++) {
                if (maze[Y][X] == 'S')
                    start = new int[] { Y, X };
                if (maze[Y][X] == 'L')
                    lever = new int[] { Y, X };
            }
        }

        int distanceL = BFS(start, 'L');
        System.out.println(distanceL);
        int distanceE = BFS(lever, 'E');
        System.out.println(distanceE);

        if (distanceL == -1 || distanceE == -1)
            return -1;

        return distanceL + distanceE;
    }

    private static int BFS(int[] location, char target) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        q.add(new int[] { location[0], location[1], 0 });

        while (!q.isEmpty()) {
            int y = q.peek()[0];
            int x = q.peek()[1];
            int count = q.peek()[2];
            visited[y][x] = true;

            if (maze[y][x] == target)
                return count;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if (tx >= 0 && tx < maze[0].length && ty >= 0 && ty < maze.length && !visited[ty][tx]) {
                    if (maze[ty][tx] != 'X') {
                        visited[ty][tx] = true;
                        q.add(new int[] { ty, tx, count + 1 });
                    }
                }
            }
        }

        return -1;
    }
}
