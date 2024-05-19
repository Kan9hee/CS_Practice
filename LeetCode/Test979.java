package LeetCode;

public class Test979 {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        private int result = 0;

        public int dfs(TreeNode current) {
            if (current == null)
                return 0;
            int leftNodeVal = dfs(current.left);
            int rightNodeVal = dfs(current.right);
            result += Math.abs(leftNodeVal) + Math.abs(rightNodeVal);
            return current.val + leftNodeVal + rightNodeVal - 1;
        }

        public int distributeCoins(TreeNode root) {
            dfs(root);
            return result;
        }
    }
}
