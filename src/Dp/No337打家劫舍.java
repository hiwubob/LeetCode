package Dp;

public class No337��ҽ��� {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int s0=0;//��ʾ͵�͸��ڵ����ڵ���һ��
        int s1=root.val;//͵���ڵ�������һ��Ͳ��������ڵĲ�
        if (root.left != null) {
            s1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            s1 += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(s0, s1);
    }
}
