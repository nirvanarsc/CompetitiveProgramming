package biweekly_contests.biweekly_21;

import utils.DataStructures.TreeNode;

public class P_1373 {

    static class Pair {
        int max;
        int min;
        int sum;
        boolean isBst;

        Pair(int max, int min, int sum, boolean isBst) {
            this.max = max;
            this.min = min;
            this.sum = sum;
            this.isBst = isBst;
        }
    }

    public static Pair dfs(TreeNode root, int[] res) {
        if (root == null) {
            return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
        }
        final Pair l = dfs(root.left, res);
        final Pair r = dfs(root.right, res);
        if (l.max >= root.val || r.min <= root.val) {
            return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, false);
        }
        final int total = l.sum + r.sum + root.val;
        if (l.isBst && r.isBst) {
            res[0] = Math.max(res[0], total);
        }
        return new Pair(Math.max(r.max, root.val), Math.min(l.min, root.val), total, true);
    }

    public int maxSumBST(TreeNode root) {
        final int[] res = { 0 };
        dfs(root, res);
        return res[0];
    }
}
