package BST;
import java.util.Stack;

public class inOrder {
	public void inOrder(TreeNode root) {

		Stack<TreeNode> stack = new Stack<>();

		while (root != null && !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				root = stack.pop();
				System.out.println(root.val);
				root = root.right;
			}
		}
	}

	public void inOrder2(TreeNode root) {

		if (root != null) {
			inOrder2(root.left);
			inOrder2(root.right);
			System.out.println(root.val);
		}
	}
}