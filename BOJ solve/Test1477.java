import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Test1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(l);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);

        int left = 1;
        int right = l - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(list, m, mid))
                left = mid + 1;
            else
                right = mid - 1;
        }

        System.out.println(left);
    }

    private static boolean check(List<Integer> nodes, int m, int mid) {
        int count = 0;

        for (int i = 1; i < nodes.size(); i++) {
            int val = nodes.get(i) - nodes.get(i - 1) - 1;
            if (val > 0)
                count += val / mid;
        }

        return count > m;
    }
}
