import java.io.*;
import java.util.*;

public class Test1208 {
    static ArrayList<Integer> arrL = new ArrayList<>();
    static ArrayList<Integer> arrR = new ArrayList<>();
    static int[] list;
    static long answer;
    static int n, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("\\s+");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        list = new int[n];

        input = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++)
            list[i] = Integer.parseInt(input[i]);

        addValueToArr(0, n / 2, 0, arrL);
        addValueToArr(n / 2, n, 0, arrR);
        Collections.sort(arrL);
        Collections.sort(arrR);

        int l = 0;
        int r = arrR.size() - 1;
        while (l < arrL.size() && r >= 0) {
            int tl = arrL.get(l);
            int tr = arrR.get(r);
            if (tl + tr > s)
                r--;
            else if (tl + tr < s)
                l++;
            else if (tl + tr == s) {
                long lc = 0;
                long rc = 0;
                while (l < arrL.size() && arrL.get(l) == tl) {
                    l++;
                    lc++;
                }
                while (r >= 0 && arrR.get(r) == tr) {
                    r--;
                    rc++;
                }
                answer += lc * rc;
            }
        }

        if (s == 0)
            answer--;

        System.out.println(answer);
    }

    private static void addValueToArr(int start, int end, int val, ArrayList<Integer> arr) {
        if (start == end) {
            arr.add(val);
            return;
        }
        addValueToArr(start + 1, end, val + list[start], arr);
        addValueToArr(start + 1, end, val, arr);
    }
}
