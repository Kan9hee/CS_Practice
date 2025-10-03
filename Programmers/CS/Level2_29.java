package CS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Level2_29 {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] result = solution(s);
        for (int r : result)
            System.out.println(r);
    }

    public static int[] solution(String s) {
        String filteredString = s.substring(2, s.length() - 2).replace("},{", "-");

        String[] arr = filteredString.split("-");
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        Set<Integer> set = new LinkedHashSet<>();

        for (int i = 0; i < arr.length; i++) {
            String[] temp = arr[i].split(",");
            for (int j = 0; j < temp.length; j++) {
                int val = Integer.parseInt(temp[j]);
                set.add(val);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
