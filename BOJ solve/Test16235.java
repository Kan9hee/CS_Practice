import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test16235 {
    static class Tree implements Comparable<Tree> {
        int x, y, z;

        public Tree(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Tree o) {
            return this.z - o.z;
        }
    }

    static int[] moveX = { -1, 1, 0, 0, -1, 1, -1, 1 };
    static int[] moveY = { 0, 0, -1, 1, -1, -1, 1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][n + 1];
        int[][] add = new int[n + 1][n + 1];
        Queue<Tree> trees = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = 5;
                add[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, z));
        }
        Collections.sort((List<Tree>) trees);

        for (int a = 0; a < k; a++) {
            ArrayList<Tree> dead = new ArrayList<>();

            int length = trees.size();
            while (length-- > 0) {
                Tree tree = trees.poll();
                if (tree.z <= map[tree.x][tree.y]) {
                    map[tree.x][tree.y] -= tree.z;
                    trees.add(new Tree(tree.x, tree.y, tree.z + 1));
                } else {
                    dead.add(new Tree(tree.x, tree.y, tree.z));
                }
            }

            for (Tree tree : dead)
                map[tree.x][tree.y] += tree.z / 2;
            ArrayList<Tree> parent = new ArrayList<>();
            length = trees.size();

            while (length-- > 0) {
                Tree tree = trees.poll();
                parent.add(tree);
                if (tree.z % 5 == 0) {
                    for (int d = 0; d < 8; d++) {
                        int nx = tree.x + moveX[d];
                        int ny = tree.y + moveY[d];
                        if (1 <= nx && nx <= n && 1 <= ny && ny <= n)
                            trees.add(new Tree(nx, ny, 1));
                    }
                }
            }

            for (Tree tree : parent)
                trees.add(tree);

            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    map[i][j] += add[i][j];
        }

        System.out.println(trees.size());
    }
}
