import java.io.*;
import java.util.*;

public class Test6550 {
    static String s, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            s = st.nextToken();
            t = st.nextToken();
            System.out.println(check() ? "Yes" : "No");
        }
    }

    private static boolean check() {
        int sCount = 0;
        for (int i = 0; i < t.length() && sCount != s.length(); i++) {
            if (s.charAt(sCount) == t.charAt(i))
                sCount++;
        }
        return sCount == s.length();
    }
}
