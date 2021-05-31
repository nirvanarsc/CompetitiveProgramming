package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.TreeNode;

public class P_111 {

    public int minDepth(TreeNode root) {
        final int res = dfs(root);
        return res == (int) 1e9 ? 0 : res;
    }

    private static int dfs(TreeNode node) {
        if (node == null) {
            return (int) 1e9;
        }
        final int res = Math.min(dfs(node.left), dfs(node.right));
        return (res == (int) 1e9 ? 0 : res) + 1;
    }

    public int minDepthBFS(TreeNode root) {
        final Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.offerLast(root);
        }
        for (int depth = 1; !queue.isEmpty(); depth++) {
            for (int size = queue.size(); size > 0; size--) {
                final TreeNode curr = queue.removeFirst();
                if (curr.left == null && curr.right == null) {
                    return depth;
                }
                if (curr.right != null) { queue.offerLast(curr.right); }
                if (curr.left != null) { queue.offerLast(curr.left); }
            }
        }
        return 0;
    }
}
