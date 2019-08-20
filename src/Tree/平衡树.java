package Tree;

public class Æ½ºâÊ÷ {
    private boolean isBlance=false;

    public boolean balance(TreeNode root) {
        height(root);
        return isBlance;
    }

    private int height(TreeNode root) {
        if (root == null || !isBlance) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            isBlance = false;
        }
        return 1 + Math.max(left, right);
    }
}
