import java.util.*;

public class Test1027 {
    static int[] buildings;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.nextLine());
        buildings = new int[N];

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < N; i++)
            buildings[i] = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int i = 0; i < N; i++)
            result = Math.max(result, coundUnderBuildings(i));

        System.out.println(result);
        sc.close();
    }

    private static int coundUnderBuildings(int num) {
        int count = 0;
        double beforeSlope = 0;

        for (int i = num - 1; i >= 0; i--) {
            double slope = (double) (buildings[num] - buildings[i]) / (num - i);
            if (i == num - 1 || beforeSlope > slope) {
                count++;
                beforeSlope = slope;
            }
        }

        for (int i = num + 1; i < N; i++) {
            double slope = (double) (buildings[num] - buildings[i]) / (num - i);
            if (i == num + 1 || beforeSlope < slope) {
                count++;
                beforeSlope = slope;
            }
        }

        return count;
    }
}
