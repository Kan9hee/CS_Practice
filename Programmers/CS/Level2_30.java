package CS;

public class Level2_30 {
    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
    }

    public static int solution(int n, int k) {
        String[] arr = Integer.toString(n, k).split("0");
        int answer = 0;

        for (String temp : arr) {
            if (!temp.isEmpty() && !temp.equals("1")) {
                Long val = Long.parseLong(temp);
                boolean check = true;
                for (long i = 2; i * i <= val; i++) {
                    if (val % i == 0) {
                        check = false;
                        break;
                    }
                }
                if (check)
                    answer++;
            }
        }

        return answer;
    }
}
