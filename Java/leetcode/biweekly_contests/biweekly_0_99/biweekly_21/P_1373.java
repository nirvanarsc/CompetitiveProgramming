package leetcode.biweekly_contests.biweekly_0_99.biweekly_21;

import utils.DataStructures.TreeNode;

public class P_1373 {

    static class Pair {
        int max;
        int min;
        int sum;

        Pair(int max, int min, int sum) {
            this.max = max;
            this.min = min;
            this.sum = sum;
        }
    }

    public static Pair dfs(TreeNode root, int[] res) {
        if (root == null) {
            return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        final Pair l = dfs(root.left, res);
        final Pair r = dfs(root.right, res);
        if (l.max >= root.val || r.min <= root.val) {
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        final int total = l.sum + r.sum + root.val;
        res[0] = Math.max(res[0], total);
        return new Pair(Math.max(r.max, root.val), Math.min(l.min, root.val), total);
    }

    public int maxSumBST(TreeNode root) {
        final int[] res = { 0 };
        dfs(root, res);
        return res[0];
    }
}
