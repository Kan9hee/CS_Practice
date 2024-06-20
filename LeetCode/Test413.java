package LeetCode;

public class Test413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3)
            return 0;

        int result = 0;
        int stack = 0;

        for (int i = 2; i < nums.length; i++) {
            stack = ((nums[i - 2] - nums[i - 1]) == (nums[i - 1] - nums[i])) ? stack + 1 : 0;
            result += stack;
        }

        return result;
    }
}
