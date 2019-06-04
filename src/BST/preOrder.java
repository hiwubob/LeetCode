package BST;
import java.util.Stack;

public class preOrder {
	public void preOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();

		while (root != null && !stack.isEmpty()) {
			while (root != null) {
				System.out.println(root.val);
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				root = stack.pop();
				root = root.right;
			}

		}
	}

	public void preOrder2(TreeNode root) {
		if (root != null) {
			System.out.println(root.val);
			preOrder2(root.left);
			preOrder2(root.right);
		}
	}
}
