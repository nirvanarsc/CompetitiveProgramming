package leetcode.weekly_contests.weekly_127;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_1008 {

    public TreeNode bstFromPreorderBF(int[] preorder) {
        return recurse(preorder, 0, preorder.length - 1);
    }

    private static TreeNode recurse(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        final TreeNode node = new TreeNode(preorder[start]);
        int newEnd = start + 1;
        while (newEnd <= end && preorder[newEnd] < preorder[start]) {
            newEnd++;
        }

        node.left = recurse(preorder, start + 1, newEnd - 1);
        node.right = recurse(preorder, newEnd, end);
        return node;
    }

    static int idx;

    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static TreeNode dfs(int[] preorder, int lo, int hi) {
        if (idx == preorder.length) {
            return null;
        }
        final int val = preorder[idx];
        if (val < lo || val > hi) {
            return null;
        }
        idx++;
        final TreeNode root = new TreeNode(val);
        root.left = dfs(preorder, lo, val);
        root.right = dfs(preorder, val, hi);
        return root;
    }
}
