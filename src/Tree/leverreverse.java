package Tree;

import java.util.*;

public class leverreverse {
    public List<List<TreeNode>> leverecer(TreeNode root) {

        List<List<TreeNode>> res=new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Stack<List> stack=new Stack<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i!=size;i++) {
                TreeNode cur=queue.poll();
                list.add(cur.val);
                if(cur.left!=null) {
                    queue.offer(cur.left);
                }
                if(cur.right!=null) {
                    queue.offer(cur.right);
                }
            }

            stack.push(list);
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

}
