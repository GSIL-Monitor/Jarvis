package offer;

/**
 * Created by Poker on 2016/11/3.
 */
public class _17_树的子结构 {

    public boolean hasSubtree(TreeNode root, TreeNode target) {
        if (target == root) {
            return true;
        }
        if (target == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        boolean result = false;
        if (target.val == root.val) {
            result = match(root, target);
        }
        if (result) {
            return true;
        } else {
            return hasSubtree(root.left, target) || hasSubtree(root.right, target);
        }

    }

    private boolean match(TreeNode root1, TreeNode root2) {
        if (root2 == root1 || root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return match(root1.left, root2.left) && match(root1.right, root2.right);
        }
        return false;
    }

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
