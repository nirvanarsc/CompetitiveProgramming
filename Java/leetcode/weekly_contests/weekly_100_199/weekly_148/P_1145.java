package leetcode.weekly_contests.weekly_100_199.weekly_148;

import utils.DataStructures.TreeNode;

public class P_1145 {

    int left, right;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        count(root, x);
        return Math.max(Math.max(left, right), n - left - right - 1) > n / 2;
    }

    private int count(TreeNode node, int x) {
        if (node == null) { return 0; }
        final int l = count(node.left, x);
        final int r = count(node.right, x);
        if (node.val == x) {
            left = l;
            right = r;
        }
        return 1 + l + r;
    }
}
