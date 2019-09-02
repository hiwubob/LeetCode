package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T144pre{
//非递归
	public List<Integer> preOrderTraversal(TreeNode root){
		List<Integer> resList=new ArrayList<>();
		if(root!=null) {
			Stack<TreeNode> stack =new Stack<>();
			stack.push(root);
			while(!stack.isEmpty()) {
				root=stack.pop();
				resList.add(root .val);
				if(root.right!=null) {//右！！
					stack.push(root.right);
				}
				if(root.left!=null) {//左！！
					stack.push(root.left);
				}
			}
		}
		return resList;
	}
}
