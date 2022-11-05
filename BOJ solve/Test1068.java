import java.io.*;
import java.util.*;

public class Test1068 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int size, tree[], count = 0;
    static boolean visited[];

    static void deleteNode(int d) {
        tree[d] = -2;
        for (int i = 0; i < size; i++) {
            if (tree[i] == d) {
                deleteNode(i);
            }
        }
    }

    public static void countLeaf(int s) {
        boolean isLeaf = true;
        visited[s] = true;
        if (tree[s] != -2) {
            for (int i = 0; i < size; i++) {
                if (tree[i] == s && visited[i] == false) {
                    countLeaf(i);
                    isLeaf = false;
                }
            }
            if (isLeaf)
                count++;
        }
    }

    public static void main(String[] args) throws IOException {
        size = Integer.parseInt(br.readLine());
        tree = new int[size];
        visited = new boolean[size + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        int delete = Integer.parseInt(br.readLine());

        deleteNode(delete);
        countLeaf(0);

        System.out.println(count);
    }
}