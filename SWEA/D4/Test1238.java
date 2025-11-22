package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");

            List<List<Integer>> map = new ArrayList<>();
            boolean[] check = new boolean[101];
            String[] setup = br.readLine().split(" ");
            int length = Integer.parseInt(setup[0]);
            int start = Integer.parseInt(setup[1]);

            for (int i = 0; i <= 100; i++)
                map.add(new ArrayList<>());

            String[] input = br.readLine().split(" ");
            for (int i = 0; i < length; i += 2) {
                int s = Integer.parseInt(input[i]);
                int e = Integer.parseInt(input[i + 1]);
                map.get(s).add(e);
            }

            List<Integer> nums = new ArrayList<>();
            Queue<int[]> q = new LinkedList<>();
            int time = 1;
            q.add(new int[] { time, start });
            while (!q.isEmpty()) {
                int[] temp = q.poll();
                for (int next : map.get(temp[1])) {
                    if (!check[next]) {
                        check[next] = true;
                        int nextTime = temp[0] + 1;
                        if (nextTime > time) {
                            time = nextTime;
                            nums.clear();
                            nums.add(next);
                        } else if (nextTime == time)
                            nums.add(next);
                        q.add(new int[] { nextTime, next });
                    }
                }
            }

            int result = 0;
            for (int num : nums)
                result = Math.max(result, num);

            sb.append(result);
            System.out.println(sb.toString());
        }

        br.close();
    }
}
