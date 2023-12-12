package CS;
public class Level3_1 {
    static boolean[] binary;
    static int treeLen, result;

    public static void main(String[] args) {
        long[] numbers = { 7, 42, 5 };
        for (int ans : solution(numbers)) {
            System.out.println(ans);
        }
    }

    public static int[] solution(long[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            String binaryString = Long.toBinaryString(numbers[i]);

            int length = binaryString.length();
            int count = 1;
            do {
                treeLen = (int) Math.pow(2, count++) - 1;
            } while (treeLen < length);

            binary = new boolean[treeLen];
            int idx = treeLen - length;
            for (int j = 0; j < length; j++)
                binary[idx++] = binaryString.charAt(j) == '1';

            result = 1;
            possible(0, treeLen - 1, false);
            answer[i] = result;
        }

        return answer;
    }

    private static void possible(int start, int end, boolean check) {
        int mid = (start + end) / 2;

        if (check && binary[mid]) {
            result = 0;
            return;
        }

        if (start != end) {
            possible(start, mid - 1, !binary[mid]);
            possible(mid + 1, end, !binary[mid]);
        }
    }
}
