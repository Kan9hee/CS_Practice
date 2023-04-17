public class Level2_6 {
    public static void main(String[] args) {
        System.out.println(solution(2554));
    }

    public static int solution(int storey) {

        if (storey <= 1)
            return storey;

        int calculStorey = storey / 10, now = storey % 10;
        int upper = now + solution(calculStorey);
        int minus = 10 - now + solution(calculStorey + 1);

        return Math.min(upper, minus);
    }
}

/*
 * 2554
 * 255,4
 * 25,5 25,6
 * 2,5 2,6
 * 0,2 0,3
 * 
 * 7,8 8,9
 * 12,13 13,14
 * 16,17 17,18
 * 16
 */