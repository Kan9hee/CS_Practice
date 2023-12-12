package CS;
public class Level3_3 {
    public static void main(String[] args) {
        int[] numbers = { 9 };
        System.out.println(solution(16, numbers, 2));
    }

    public static int solution(int n, int[] stations, int w) {
        int answer = 0, place = 1;

        for (int i = 0; i < stations.length; i++) {
            if (place < stations[i] - w)
                answer += deploy(place, stations[i] - w - 1, w);
            place = stations[i] + w + 1;
        }

        if (stations[stations.length - 1] + w < n)
            answer += deploy(stations[stations.length - 1] + w + 1, n, w);

        return answer;
    }

    private static int deploy(int left, int right, int w) {
        int result = (right - left + 1) / (2 * w + 1);
        if ((right - left + 1) % (2 * w + 1) != 0)
            result++;
        return result;
    }
}
