package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T94inorder中序 {
//非递归
	public List<Integer> inOrderTraversal(TreeNode root){
		List<Integer> resList=new ArrayList<>();
		if(root!=null) {
			Stack<TreeNode> stack =new Stack<>();
			
			while(!stack.isEmpty() || root!=null) {
				if(root!=null) {
					stack.push(root);
					root=root.left;//把左一路压入栈
				}else {
					root=stack.pop();
					resList.add(root.val);
					root=root.right;
				}
			}
		}
		return resList;
	}
	public void inOrder2(TreeNode root) {

		if (root != null) {
			inOrder2(root.left);
			System.out.println(root.val);
			inOrder2(root.right);
		}
	}
}
