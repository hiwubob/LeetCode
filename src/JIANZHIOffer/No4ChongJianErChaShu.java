package JIANZHIOffer;



public class No4ChongJianErChaShu {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int startpre, int endpre, int[] in, int startin, int endin) {
        if (startpre > endpre || startin > endin) {
            return null;
        }
        TreeNode root=new TreeNode(pre[startpre]);
        for (int i = startin; i <= endin; i++) {
            if (in[i] == pre[startpre]) {
                root.left = reConstructBinaryTree(pre, startpre + 1, startpre + i - 1, in, startin, i - 1);
                root.right = reConstructBinaryTree(pre, i-startin+1+startpre, endpre, in, i+1, endin);
            }
        }
        return root;
    }
}
