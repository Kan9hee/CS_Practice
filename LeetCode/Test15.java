package LeetCode;

import java.util.*;

public class Test15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1, right = nums.length - 1, sum = 0;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum < 0)
                    left++;
                else if (sum > 0)
                    right--;
                else {
                    List<Integer> temp = new ArrayList<>(List.of(nums[i], nums[left], nums[right]));
                    while (temp.get(1) == nums[left] && left < nums.length - 1)
                        left++;
                    while (temp.get(2) == nums[right] && right > 0)
                        right--;
                    Collections.sort(temp);
                    result.add(temp);
                }
            }
        }
        return new ArrayList<>(result);
    }
}
