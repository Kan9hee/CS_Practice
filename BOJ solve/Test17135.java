import java.io.*;
import java.util.*;

public class Test17135 {
    private static class EnemyNode {
        int y, x;

        public EnemyNode(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] map;
    static int[] deployed = new int[3];
    static int answer = 0;
    static int n, m, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        deployArcher(0, 0);
        System.out.println(answer);
    }

    private static void deployArcher(int count, int start) {
        if (count == 3) {
            answer = Math.max(answer, defense(0));
            return;
        }

        for (int i = start; i < m; i++) {
            deployed[count] = i;
            deployArcher(count + 1, i + 1);
        }
    }

    private static int defense(int count) {
        int[][] currentMap = new int[n][m];
        for (int row = 0; row < n; row++)
            currentMap[row] = Arrays.copyOf(map[row], m);

        for (int archerLine = n; archerLine > 0; archerLine--) {
            Set<EnemyNode> targets = new HashSet<>();

            for (int archer : deployed) {
                EnemyNode target = findTarget(currentMap, archerLine, archer);
                if (target != null)
                    targets.add(target);
            }

            for (EnemyNode pos : targets) {
                if (currentMap[pos.y][pos.x] == 1) {
                    currentMap[pos.y][pos.x] = 0;
                    count++;
                }
            }
        }

        return count;
    }

    private static EnemyNode findTarget(int[][] currentMap, int line, int archer) {
        int minDist = Integer.MAX_VALUE;
        int targetY = -1;
        int targetX = -1;

        for (int y = 0; y < line; y++) {
            for (int x = 0; x < m; x++) {
                if (currentMap[y][x] == 1) {
                    int dist = Math.abs(line - y) + Math.abs(archer - x);
                    if (dist <= d) {
                        if (dist < minDist || (dist == minDist && x < targetX)) {
                            minDist = dist;
                            targetY = y;
                            targetX = x;
                        }
                    }
                }
            }
        }

        if (targetY == -1)
            return null;

        return new EnemyNode(targetY, targetX);
    }
}
