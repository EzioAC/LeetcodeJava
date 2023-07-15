package Y2023.M07;

import common.TreeNode;

public class DistributeCoins {

    static int res = 0;
    public int distributeCoins(TreeNode root) {
        res = 0;
        help(root);
        return res;
    }

    public int help(TreeNode treeNode) {
        if(treeNode == null) {
            return 0;
        }
        int left = help(treeNode.left);
        int right = help(treeNode.right);
        int need = treeNode.val - 1 +  right + left;
        res += Math.abs(need);
        return need;
    }

    public static void main(String[] args) {
        TreeNode l = new TreeNode(3, null, null);
        TreeNode r = new TreeNode(0, null, null);
        TreeNode mid = new TreeNode(0, l, r);
        DistributeCoins distributeCoins = new DistributeCoins();
        System.out.println(distributeCoins.distributeCoins(mid));
    }

}
