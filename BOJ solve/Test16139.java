import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Test16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, int[]> infos = new HashMap<>();

        String S = br.readLine();
        char[] words = S.toCharArray();
        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            char aChar = a.charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (!infos.containsKey(a)) {
                int[] tempArray = new int[S.length()];
                int val = 0;
                for (int j = 0; j < S.length(); j++) {
                    if (words[j] == aChar)
                        val++;
                    tempArray[j] = val;
                }
                infos.put(a, tempArray);
            }

            int[] sums = infos.get(a);
            int startSum = sums[l];
            int endSum = sums[r];

            if (words[l] == aChar)
                startSum--;

            int result = endSum - startSum;
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
