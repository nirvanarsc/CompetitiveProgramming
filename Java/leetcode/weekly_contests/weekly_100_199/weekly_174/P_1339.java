package leetcode.weekly_contests.weekly_100_199.weekly_174;

import utils.DataStructures.TreeNode;

public class P_1339 {

    static int total;
    static long res;

    private static final int MOD = (int) (1e9 + 7);

    public int maxProduct(TreeNode root) {
        total = 0;
        res = 0;
        dfs1(root);
        dfs2(root);
        return (int) (res % MOD);
    }

    private static void dfs1(TreeNode node) {
        if (node == null) {
            return;
        }
        total += node.val;
        dfs1(node.left);
        dfs1(node.right);
    }

    private static long dfs2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        final long ll = dfs2(node.left);
        final long rr = dfs2(node.right);
        final long curr = ll + rr + node.val;
        res = Math.max(res, curr * (total - curr));
        return curr;
    }
}
