package LeetCode;

import java.util.*;

public class Test207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> Map = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            Map.add(new ArrayList<>());

        for (int[] info : prerequisites) {
            // info는 {과목,선행조건}으로 이루어짐
            int subject = info[0];
            int prerequisite = info[1];
            Map.get(prerequisite).add(subject); // 선행조건에 대한 과목이 추가되는 방식
            inDegree[subject]++; // 선행조건이 있는 과목의 카운트를 올림
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i); // 카운트가 없는 과목(선행조건이 없는 과목)을 큐에 넣음
            }
        }

        int processed = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            processed++;
            for (int next : Map.get(temp)) {
                inDegree[next]--;
                if (inDegree[next] == 0)
                    queue.add(next); // 과목 카운트가 없을 경우(더이상 그 과목의 선행조건이 없을 경우) 큐에 추가함
            }
        }

        return processed == numCourses; // 과목을 열람한 수가 주어진 과목 수와 같은지로 결정
    }
}
