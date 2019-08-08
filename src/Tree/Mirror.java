package Tree;

public class Mirror {
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root != null) {
            TreeNode tmp=root.left;
            root.left=root.right;
            root.right=tmp;
        }

        if (root.left != null) {
            mirror(root.left);
        }
        if (root.right != null) {
            mirror(root.right);
        }

    }
}
