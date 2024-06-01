package LeetCode;

public class Test11 {
    public int maxArea(int[] height) {
        int answer = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int val = (right - left) * minHeight;
            if (val > answer)
                answer = val;
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return answer;
    }
}
