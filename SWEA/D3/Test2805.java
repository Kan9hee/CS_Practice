package SWEA.D3;

import java.io.*;

public class Test2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        for (int num = 1; num <= testCount; num++) {
            int size = Integer.parseInt(br.readLine());
            int mid = size / 2;
            int result = 0;
            int val = 0;
            for (int i = 0; i < size; i++) {
                String line = br.readLine();
                val = i <= mid ? i : size - 1 - i;
                for (int j = mid - val; j <= mid + val; j++)
                    result += Character.getNumericValue(line.charAt(j));
            }
            System.out.println("#" + num + " " + result);
        }
    }
}
