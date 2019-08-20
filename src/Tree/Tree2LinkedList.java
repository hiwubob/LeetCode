package Tree;

public class Tree2LinkedList {
    private TreeNode head=null;
    private TreeNode pre=null;

    public TreeNode Tree2Link(TreeNode root) {
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        node.left=pre;
        if (pre != null) {
            pre.right = node;
        }
        pre=node;
        if (head == null) {
            head=node;
        }
        inOrder(node.right);

    }
}
