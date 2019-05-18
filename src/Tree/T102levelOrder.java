package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T102levelOrder {
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> resList = new ArrayList<>();
		if(root==null) {
			return resList;
		}
		
		Queue<TreeNode> queue=new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size=queue.size();
			List<Integer> levelList=new ArrayList<>();
			for(int i=0;i!=size;i++) {
				TreeNode cur=queue.poll(); 
				levelList.add(cur.val);
				if(cur.left!=null) {
					queue.offer(cur.left);
				}
				if(cur.right!=null) {
					queue.offer(cur.right);
				}
			}
			resList.add(levelList);
		}
		return resList;
	}
}
