package CS;

public class Level2_19 {
    public static void main(String[] args) {
        int[][] users = { { 40, 10000 }, { 25, 10000 } };
        int[] emoticons = { 7000, 9000 };

        int[] result = solution(users, emoticons);
        for (int val : result)
            System.out.println(val);
    }

    private static int[] answer;

    public static int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        int[] discounts = new int[emoticons.length];

        DFS(users, emoticons, discounts, 0);
        return answer;
    }

    private static void DFS(int[][] users, int[] emoticons, int[] discounts, int emoticonNum) {
        int plusJoinCount = 0;
        int emoticonRevenue = 0;

        for (int[] user : users) {
            int purchaseCost = 0;
            for (int i = 0; i < emoticons.length; i++) {
                if (user[0] <= discounts[i]) {
                    int discountValue = emoticons[i] * discounts[i] / 100;
                    int emoticonPrice = emoticons[i] - discountValue;
                    purchaseCost += emoticonPrice;
                }
            }
            if (purchaseCost >= user[1])
                plusJoinCount++;
            else
                emoticonRevenue += purchaseCost;
        }

        if (answer[0] < plusJoinCount) {
            answer[0] = plusJoinCount;
            answer[1] = emoticonRevenue;
        } else if (answer[0] == plusJoinCount) {
            answer[1] = Math.max(answer[1], emoticonRevenue);
        }

        for (int i = emoticonNum; i < emoticons.length; i++) {
            discounts[i] += 10;
            if (discounts[i] > 40) {
                discounts[i] -= 10;
                continue;
            }
            DFS(users, emoticons, discounts, i);
            discounts[i] -= 10;
        }
    }
}
