import java.util.*;

public class level1_4 {
    public static void main(String args[]) {
        String[] name = { "may", "kein", "kain", "radi" };
        int[] yearning = { 5, 10, 1, 3 };
        String[][] photo = { { "may", "kein", "kain", "radi" },
                { "may", "kein", "brin", "deny" },
                { "kon", "kain", "may", "coni" } };

        Map<String, Integer> points = new HashMap<>();
        int[] answer = new int[photo.length];

        for (int i = 0; i < name.length; i++)
            points.put(name[i], yearning[i]);

        Arrays.fill(answer, 0);

        for (int i = 0; i < photo.length; i++)
            for (String people : photo[i])
                if (points.get(people) != null)
                    answer[i] += points.get(people);

        for (int a : answer)
            System.out.println(a);
    }
}