package Tree;

public class T230kthSmallest {
	int count = 0;
	int value = 0;

	public int kthSmallest(TreeNode root, int k) {
		kthSmallestInOrder(root, k);
		return value;
	}

	private void kthSmallestInOrder(TreeNode node, int k) {
		if (node == null|| count>k) {
			return;
		}

		kthSmallestInOrder(node.left, k);
		count++;
		if (k == count) {
			value = node.val;
		}
		kthSmallestInOrder(node.right, k);
	}
}
