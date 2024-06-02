package LeetCode;

import java.util.*;

public class Test39 {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        dfs(candidates, new ArrayList<Integer>(), 0, 0, target);
        return result;
    }

    private void dfs(int[] candidates, List<Integer> current, int num, int sum, int target) {
        if (sum > target)
            return;
        else if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = num; i < candidates.length; i++) {
            sum += candidates[i];
            current.add(candidates[i]);
            dfs(candidates, current, i, sum, target);
            sum -= candidates[i];
            current.remove(current.size() - 1);
        }
    }
}
