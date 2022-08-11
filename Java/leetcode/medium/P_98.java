package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.TreeNode;

public class P_98 {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, (long) -1e18, (long) 1e18);
    }

    private static boolean dfs(TreeNode node, long lo, long hi) {
        if (node == null) {
            return true;
        }
        if (!(lo < node.val && node.val < hi)) {
            return false;
        }
        return dfs(node.left, lo, node.val) && dfs(node.right, node.val, hi);
    }

    public boolean isValidBSTIterative(TreeNode root) {
        final Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null, curr = root;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            } else {
                curr = stack.removeFirst();
                if (prev != null && curr.val <= prev.val) { return false; }
                prev = curr;
                curr = curr.right;
            }
        }

        return true;
    }
}
