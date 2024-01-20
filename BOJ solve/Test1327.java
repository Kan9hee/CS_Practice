import java.io.*;
import java.util.*;

public class Test1327 {
    static class Info {
        String str;
        int count;

        public Info(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }

    static Set<String> usedList = new HashSet<>();
    static int n, k;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        char[] originArr = br.readLine().replace(" ", "").toCharArray();
        String origin = new String(originArr);
        String answerStr = "";

        Arrays.sort(originArr);
        for (int i = 0; i < n; i++)
            answerStr += originArr[i];

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(origin, 0));
        while (!q.isEmpty()) {
            Info temp = q.poll();
            if (answerStr.equals(temp.str)) {
                result = temp.count;
                break;
            }
            if (!usedList.contains(temp.str)) {
                usedList.add(temp.str);
                for (int i = 0; i <= n - k; i++)
                    q.add(new Info(reassembly(i, i + k, temp.str), temp.count + 1));
            }
        }

        System.out.println(result);
    }

    private static String reassembly(int start, int end, String str) {
        StringBuffer sb = new StringBuffer();
        sb.append(str.substring(0, start));
        String target = str.substring(start, end);
        for (int i = k - 1; i >= 0; i--)
            sb.append(target.charAt(i));
        sb.append(str.substring(end));
        return sb.toString();
    }
}
