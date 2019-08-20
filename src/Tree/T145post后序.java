package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T145post后序{
	public List<Integer> postOrderTraversal(TreeNode root) {
		List<Integer> resList = new ArrayList<>();
		if (root != null) {
			Stack<TreeNode> s1 = new Stack<>();
			Stack<TreeNode> s2 = new Stack<>();
			s1.push(root);
			while (!s1.isEmpty()) {//根节点入s1，root=s1.pop到s2，再把root的左右入s1，往复
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
				resList.add(s2.pop().val);//s2依次弹出
			}
		}
		return resList;
	}
}
