package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.TreeNode;

@SuppressWarnings("ConstantConditions")
public class P_111 {

    public int minDepth(TreeNode root) {
        final int[] res = { (int) 1e9 };
        dfs(root, 1, res);
        return res[0] == (int) 1e9 ? 0 : res[0];
    }

    private static void dfs(TreeNode node, int d, int[] res) {
        if (node == null) {
            return;
        }
        dfs(node.left, d + 1, res);
        if (node.left == null && node.right == null) {
            res[0] = Math.min(res[0], d);
        }
        dfs(node.right, d + 1, res);
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
