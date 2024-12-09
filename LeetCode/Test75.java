package LeetCode;

//You must solve this problem without using the library's sort function.

public class Test75 {
    public void sortColors(int[] nums) {
        int[] answer = mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++)
            nums[i] = answer[i];
    }

    int[] mergeSort(int[] nums, int left, int right) {
        if (left == right)
            return new int[] { nums[left] };

        int mid = (left + right) / 2;
        int[] leftList = mergeSort(nums, left, mid);
        int[] rightList = mergeSort(nums, mid + 1, right);

        int length = right - left + 1;
        int i = 0, j = 0, k = 0;
        int[] result = new int[length];

        while (i < leftList.length && j < rightList.length) {
            if (leftList[i] <= rightList[j])
                result[k++] = leftList[i++];
            else
                result[k++] = rightList[j++];
        }

        if (i < leftList.length)
            for (; i < leftList.length; i++, k++)
                result[k] = leftList[i];
        else if (j < rightList.length)
            for (; j < rightList.length; j++, k++)
                result[k] = rightList[j];

        return result;
    }
}
