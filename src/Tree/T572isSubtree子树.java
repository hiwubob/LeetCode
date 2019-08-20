package Tree;

public class T572isSubtree×ÓÊ÷ {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null || t == null) {
			return s == null && t == null;
		}

		return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private boolean isSameTree(TreeNode s, TreeNode t) {
		if (s == null || t == null) {
			return s == null && t == null;
		}
		return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
	}
}
