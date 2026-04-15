package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Test128 {
    public static void main(String[] args) {
        int[] nums = new int[] { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));
    }

    static public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;

        if (nums.length == 0)
            return result;

        for (int n : nums)
            set.add(n);

        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int length = 1;
                int next = n;
                while (set.contains(next + 1)) {
                    length++;
                    next++;
                }
                result = Math.max(result, length);
            }
        }

        return result;
    }
}
