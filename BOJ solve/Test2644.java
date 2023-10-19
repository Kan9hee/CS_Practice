import java.io.*;
import java.util.*;

public class Test2644 {
    static boolean[][] map;
    static int mapSize, start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mapSize = Integer.parseInt(br.readLine());
        map = new boolean[mapSize + 1][mapSize + 1];

        String[] input = br.readLine().split("\\s+");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);

        int repeat = Integer.parseInt(br.readLine());

        for (int i = 0; i < repeat; i++) {
            input = br.readLine().split("\\s+");
            map[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = true;
            map[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = true;
        }

        DFS();
    }

    private static void DFS() {
        Stack<int[]> st = new Stack<>();
        st.add(new int[] { start, 0 });
        int result = -1;

        while (!st.isEmpty()) {
            int[] temp = st.pop();

            if (temp[0] == end) {
                result = temp[1];
                break;
            }

            for (int i = 1; i <= mapSize; i++) {
                if (map[temp[0]][i]) {
                    st.add(new int[] { i, temp[1] + 1 });
                    map[temp[0]][i] = false;
                    map[i][temp[0]] = false;
                }
            }
        }

        System.out.println(result);
    }
}