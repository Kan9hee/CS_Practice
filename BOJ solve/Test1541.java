import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] subStrings = br.readLine().split("-");
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < subStrings.length; i++) {
            int sum = 0;
            String[] addition = subStrings[i].split("\\+");
            for (int j = 0; j < addition.length; j++)
                sum += Integer.parseInt(addition[j]);
            values.add(sum);
        }

        int result = values.get(0);
        for (int i = 1; i < values.size(); i++)
            result -= values.get(i);

        System.out.println(result);
    }
}
