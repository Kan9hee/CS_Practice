import java.io.*;
import java.util.*;

public class Test1946 {
    static class applicant {
        private int document, interview;

        public applicant(int x, int y) {
            document = x;
            interview = y;
        }

        public int getDocument() {
            return document;
        }

        public int getInterview() {
            return interview;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static applicant[] list;

    static int employment(int scale) {
        int count = 1;
        int min = list[0].getInterview();
        for (int i = 1; i < scale; i++) {
            if (list[i].getInterview() < min) {
                count++;
                min = list[i].getInterview();
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        int tests = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < tests; t++) {
            int scale = Integer.parseInt(br.readLine());
            list = new applicant[scale];

            for (int i = 0; i < scale; i++) {
                st = new StringTokenizer(br.readLine());
                int doc = Integer.parseInt(st.nextToken());
                int in = Integer.parseInt(st.nextToken());
                list[i] = new applicant(doc, in);
            }

            Arrays.sort(list, new Comparator<applicant>() {
                @Override
                public int compare(applicant a1, applicant a2) {
                    return Integer.compare(a1.getDocument(), a2.getDocument());
                }
            });

            System.out.println(employment(scale));
        }
    }
}