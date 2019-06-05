package BST;
import java.util.ArrayList;

import java.util.List;
import java.util.Stack;
//首先root入s1，s1弹出root入s2，把root的左右入栈s1，重复“弹出root入s2，把root的左右入栈s1”，最后输出s2pop
public class postOrder {
	public void postOrder1(TreeNode root) {
		if (root != null) {
			Stack<TreeNode> s1=new Stack<>();
			Stack<TreeNode> s2 = new Stack<>();
			s1.push(root);
			while (!s1.isEmpty()) {
				root = s1.pop();
				s2.push(root);
				if (root.left != null) {
					s1.push(root.left);
				}
				if (root.right != null) {
					s1.push(root.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.println(s2.pop().val);
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

	public void postOrder3(TreeNode root) {

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
}
