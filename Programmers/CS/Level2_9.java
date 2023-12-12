package CS;
import java.util.*;

public class Level2_9 {
    public static void main(String[] args) {
        String[][] plans = { { "science", "12:40", "50" }, { "music", "12:20", "40" }, { "history", "14:00", "30" },
                { "computer", "12:30", "100" } };
        for (String temp : solution(plans)) {
            System.out.println(temp);
        }
    }

    public static String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Stack<String[]> pause = new Stack<>();
        Arrays.sort(plans, (p1, p2) -> calculateTime(p1[1]) - (calculateTime(p2[1])));
        int index = 0;
        int nextTime = 0;

        while (plans.length != index) {
            String type = plans[index][0];
            int time = calculateTime(plans[index][1]);
            int work = Integer.parseInt(plans[index][2]);
            int current = time + work;

            if (plans.length - 1 != index) {
                nextTime = calculateTime(plans[index + 1][1]);
                if (current > nextTime) {
                    pause.push(new String[] { type, Integer.toString(current - nextTime) });
                    current = nextTime;
                    index++;
                    continue;
                }
            }
            answer.add(type);

            while (!pause.isEmpty()) {
                String[] plan = pause.pop();
                int between = nextTime - current;
                int remainTime = Integer.parseInt(plan[1]);
                if (between >= remainTime) {
                    answer.add(plan[0]);
                    current += remainTime;
                } else {
                    pause.push(new String[] { plan[0], Integer.toString(remainTime - between) });
                    break;
                }
            }
            index++;
        }

        while (!pause.isEmpty())
            answer.add(pause.pop()[0]);

        return answer.toArray(new String[plans.length]);
    }

    static public int calculateTime(String time) {
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]) * 60;
        int m = Integer.parseInt(t[1]);
        return h + m;
    }
}
