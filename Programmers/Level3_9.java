import java.util.Arrays;
import java.util.PriorityQueue;

public class Level3_9 {
    public static void main(String[] args) {
        int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        PriorityQueue<int[]> jobQueue = new PriorityQueue<>((job1, job2) -> job1[1] - job2[1]);
        int currentTime = 0, workTime = 0, arraiveJob = 0, finishedJob = 0;

        Arrays.sort(jobs, (job1, job2) -> job1[0] - job2[0]);

        while (finishedJob < jobs.length) {
            while (arraiveJob < jobs.length && jobs[arraiveJob][0] <= currentTime) {
                jobQueue.add(jobs[arraiveJob++]);
            }

            if (jobQueue.isEmpty())
                currentTime = jobs[arraiveJob][0];
            else {
                int[] job = jobQueue.poll();
                currentTime += job[1];
                workTime += currentTime - job[0];
                finishedJob++;
            }
        }

        return (int) workTime / jobs.length;
    }
}