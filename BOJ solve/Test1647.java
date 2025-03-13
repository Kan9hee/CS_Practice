import java.util.*;

public class Test1647 {

    static class Road {
        int start, end, weight;

        public Road(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static int[] roots;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        roots = new int[N + 1];
        for (int i = 1; i <= N; i++)
            roots[i] = i;
        ArrayList<Road> roadList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(sc.nextLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            roadList.add(new Road(a, b, c));
        }

        Collections.sort(roadList, (r1, r2) -> r1.weight - r2.weight);

        int totalMinimumWeight = 0;
        int biggestWeight = 0;

        for (int i = 0; i < M; i++) {
            Road temp = roadList.get(i);
            int startRoot = getRoot(temp.start);
            int endRoot = getRoot(temp.end);
            if (startRoot != endRoot) {
                totalMinimumWeight += temp.weight;
                roots[endRoot] = startRoot;
                biggestWeight = temp.weight;
            }
        }

        System.out.println(totalMinimumWeight - biggestWeight);
        sc.close();
    }

    static int getRoot(int num) {
        if (num == roots[num])
            return num;
        roots[num] = getRoot(roots[num]);
        return roots[num];
    }
}
