import java.io.*;
import java.util.*;

public class Test1924 {
    static String[] week = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
    static int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        for (int i = 1; i < month; i++)
            day += days[i];
        System.out.println(week[day % 7]);
    }
}
