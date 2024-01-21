import java.io.*;
import java.util.*;

public class Test1516 {
    static class Info {
        int num, time, before; // 현재 테크, 건설 시간, 필요 테크 수

        public Info(int num, int time, int before) {
            this.num = num;
            this.time = time;
            this.before = before;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> tech = new ArrayList<>(); // 필요 테크 리스트
        Info[] list = new Info[n + 1];
        for (int i = 0; i <= n; i++)
            tech.add(new ArrayList<>());

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split("\\s+");
            int tt = Integer.parseInt(input[0]);
            int count = 0;
            for (int j = 1; j < input.length - 1; j++) {
                // 받은 정보에서 필요로 하는 테크의 tech에 현재 테크를 삽입
                tech.get(Integer.parseInt(input[j])).add(i);
                count++; // 필요 테크 수 증가
            }
            list[i] = new Info(i, tt, count);
        }

        PriorityQueue<Info> pq = new PriorityQueue<>((Info n1, Info n2) -> (n1.time - n2.time));
        for (int i = 1; i <= n; i++)
            if (list[i].before == 0)
                pq.add(list[i]);
        while (!pq.isEmpty()) {
            Info temp = pq.poll();
            // 전체 테크에서 현재 temp의 테크가 쓰이는 경우를 확인
            for (int next : tech.get(temp.num)) {
                list[next].before--;
                if (list[next].before == 0) {
                    list[next].time += list[temp.num].time;
                    pq.add(new Info(next, list[next].time, 0));
                }
            }
        }

        for (int i = 1; i <= n; i++)
            System.out.println(list[i].time);
    }
}
