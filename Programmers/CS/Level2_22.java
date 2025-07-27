package CS;

import java.util.PriorityQueue;

public class Level2_22 {
    public static void main(String[] args) {
        String[][] bookTime = { { "19:10", "10:10" }, { "10:20", "12:20" } };
        System.out.println(solution(bookTime));
    }

    private static class Guest {
        int start, end;

        public Guest(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<Guest> pq = new PriorityQueue<>((n1, n2) -> n1.start - n2.start);

        for (String[] guest_time : book_time) {
            int startTime = Integer.parseInt(guest_time[0].replace(":", ""));
            int endTime = Integer.parseInt(guest_time[1].replace(":", ""));

            int endTimeMinute = endTime % 100 + 10;
            int endTimeHour = endTime / 100;
            if (endTimeMinute >= 60) {
                endTimeHour += 1;
                endTimeMinute -= 60;
            }
            endTime = endTimeHour * 100 + endTimeMinute;

            pq.add(new Guest(startTime, endTime));
        }

        Guest[] hotel = new Guest[book_time.length];
        while (!pq.isEmpty()) {
            Guest temp = pq.poll();
            for (int i = 0; i < hotel.length; i++) {
                if (hotel[i] == null) {
                    hotel[i] = temp;
                    answer++;
                    break;
                } else if (hotel[i].end <= temp.start) {
                    hotel[i] = temp;
                    break;
                }
            }
        }

        return answer;
    }
}
