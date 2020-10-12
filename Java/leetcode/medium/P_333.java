package leetcode.medium;

import utils.DataStructures.TreeNode;

public class P_333 {

    static class Pair {
        int max;
        int min;
        int size;

        Pair(int max, int min, int size) {
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }

    public static Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        final Pair l = dfs(root.left);
        final Pair r = dfs(root.right);
        if (l.max >= root.val || r.min <= root.val) {
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(l.size, r.size));
        }
        return new Pair(Math.max(r.max, root.val), Math.min(l.min, root.val), l.size + r.size + 1);
    }

    public int largestBSTSubtree(TreeNode root) {
        return dfs(root).size;
    }
}
