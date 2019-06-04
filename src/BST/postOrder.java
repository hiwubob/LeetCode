package BST;
import java.util.ArrayList;

import java.util.List;
import java.util.Stack;

public class postOrder {
	public void postOrder(TreeNode root) {

		Stack<TreeNode> stack = new Stack<>();

		TreeNode currentNode = root;
		TreeNode pre = root;
		while (currentNode != null || !stack.isEmpty()) {
			while (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			}

			if (!stack.isEmpty()) {
				TreeNode temp = stack.peek().right;
				if (temp == null || temp == pre) {
					currentNode = stack.pop();
					System.out.println(currentNode.val);
					pre = currentNode;
					currentNode = null;
				} else {
					currentNode = temp;
				}
			}
		}
		
	}
	
	public void postOrder2(TreeNode root){
		
		if(root!=null) {
			postOrder2(root.left);
			postOrder2(root.right);
			System.out.println(root.val);
		}
	

	}
}
