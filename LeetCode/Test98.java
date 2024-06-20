package LeetCode;

public class Test98 {
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

    public boolean isValidBST(TreeNode root) {
        return DFS(root, null, null);
    }

    private boolean DFS(TreeNode current, TreeNode maxLeft, TreeNode maxRight) {
        if (current == null)
            return true;

        if (maxLeft != null && current.val <= maxLeft.val)
            return false;
        if (maxRight != null && current.val >= maxRight.val)
            return false;

        if (!DFS(current.left, maxLeft, current))
            return false;
        if (!DFS(current.right, current, maxRight))
            return false;

        return true;
    }
}
