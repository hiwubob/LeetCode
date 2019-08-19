package JIANZHIOffer;

public class No40isBalanced {
    boolean isbalanced;
    public boolean isbalanced(TreeNode root) {
        height(root);
        return isbalanced;
    }

    private int height(TreeNode root) {
        if (root == null || !isbalanced) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        if (Math.abs(lh - rh) > 1) {
            isbalanced = false;
        }
        return 1 + Math.max(lh, rh);
    }
}
