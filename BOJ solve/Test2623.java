import java.util.*;

public class Test2623 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] plans = new ArrayList[n + 1];
        int[] singerPrioritys = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            plans[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(sc.nextLine());
            int line = Integer.parseInt(st.nextToken());
            int singer = Integer.parseInt(st.nextToken());
            for (int j = 1; j < line; j++) {
                int nextSinger = Integer.parseInt(st.nextToken());
                plans[singer].add(nextSinger);
                singerPrioritys[nextSinger]++;
                singer = nextSinger;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (singerPrioritys[i] == 0)
                q.add(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int temp = q.poll();
            sb.append(temp + "\n");
            count++;
            for (int next : plans[temp]) {
                singerPrioritys[next]--;
                if (singerPrioritys[next] == 0)
                    q.add(next);
            }
        }

        if (count == n)
            System.out.println(sb.toString());
        else
            System.out.println(0);

        sc.close();
    }
}
