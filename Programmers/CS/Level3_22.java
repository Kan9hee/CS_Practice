package CS;

import java.util.LinkedHashMap;
import java.util.Map;

public class Level3_22 {
    private static class Member {
        private Member recommender;
        private int revenue;

        public Member(Member recommender) {
            this.recommender = recommender;
            this.revenue = 0;
        }

        public void setRevenue(int sellPrice) {
            int newRevenue = (int) (sellPrice * 0.1);
            if (recommender == null) {
                revenue += sellPrice - newRevenue;
            } else {
                revenue += sellPrice - newRevenue;
                recommender.setRevenue(newRevenue);
            }
        }
    }

    public static void main(String[] args) {
        String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
        String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
        String[] seller = { "young", "john", "tod", "emily", "mary" };
        int[] amount = { 12, 4, 2, 5, 10 };

        int[] result = solution(enroll, referral, seller, amount);
        for (int i : result)
            System.out.println(i);
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Member> memberMap = new LinkedHashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            Member temp = referral[i].equals("-") ? null : memberMap.get(referral[i]);
            memberMap.put(enroll[i], new Member(temp));
        }

        for (int i = 0; i < seller.length; i++)
            memberMap.get(seller[i]).setRevenue(amount[i] * 100);

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++)
            answer[i] = memberMap.get(enroll[i]).revenue;

        return answer;
    }
}
