import java.util.*;

public class level1_3 {
    public static void main(String args[]) {

        String today = "2022.05.19";
        String[] terms = { "A 6", "B 12", "C 3" };
        String[] privacies = { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" };

        Map<String, Integer> termMap = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int[] date = new int[today.split("\\.").length];
        int count = 0;

        for (String d : today.split("\\.")) {
            date[count] = Integer.parseInt(d);
            count++;
        }

        for (String term : terms) {
            int expiration = Integer.parseInt(term.substring(2)) * 28;
            termMap.put(term.substring(0, 1), expiration);
        }

        for (int i = 0; i < privacies.length; i++) {
            String contract = privacies[i].split(" ")[0];
            String[] temp = contract.split("\\.");

            int year = (date[0] - Integer.parseInt(temp[0])) * 12 * 28;
            int month = (date[1] - Integer.parseInt(temp[1])) * 28;
            int day = date[2] - Integer.parseInt(temp[2]);
            if (year + month + day >= termMap.get(privacies[i].split(" ")[1])) {
                answer.add(i + 1);
            }
        }

        int[] arr = answer.stream().mapToInt(i -> i).toArray();

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
