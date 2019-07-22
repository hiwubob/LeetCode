package Dp;

public class No337打家劫舍 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int s0=0;//表示偷和根节点相邻的那一层
        int s1=root.val;//偷根节点所在那一层和不和它相邻的层
        if (root.left != null) {
            s1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            s1 += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(s0, s1);
    }
}
