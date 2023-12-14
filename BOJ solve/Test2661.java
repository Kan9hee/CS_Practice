import java.util.Scanner;

public class Test2661 {
    static int n;
    static long answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        find("");

        System.out.println(answer);
    }

    private static void find(String val) {
        if (val.length() == n) {
            System.out.println(val);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            String temp = val + i;
            if (check(temp))
                find(temp);
        }
    }

    private static boolean check(String exam) {
        for (int i = 1; i <= exam.length() / 2; i++) {
            String t1 = exam.substring(exam.length() - i, exam.length());
            String t2 = exam.substring(exam.length() - i * 2, exam.length() - i);
            if (t1.equals(t2))
                return false;
        }
        return true;
    }
}
