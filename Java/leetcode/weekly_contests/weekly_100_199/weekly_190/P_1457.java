package leetcode.weekly_contests.weekly_100_199.weekly_190;

import utils.DataStructures.TreeNode;

@SuppressWarnings("ConstantConditions")
public class P_1457 {

    static int res;
    static int mask;

    public int pseudoPalindromicPaths(TreeNode root) {
        res = 0;
        mask = 0;
        dfs(root);
        return res;
    }

    private static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        mask ^= 1 << node.val;
        dfs(node.left);
        if (node.left == null && node.right == null) {
            if ((mask & (mask - 1)) == 0) {
                res++;
            }
        }
        dfs(node.right);
        mask ^= 1 << node.val;
    }
}
