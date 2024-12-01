package LeetCode;

//Definition for a binary tree node.

public class Test129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int before) {
        int updatedValue = before * 10 + node.val;
        if (node.left == null && node.right == null)
            return updatedValue;

        int result = 0;
        if (node.left != null)
            result += dfs(node.left, updatedValue);
        if (node.right != null)
            result += dfs(node.right, updatedValue);
        return result;
    }

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
}
