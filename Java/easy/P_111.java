package easy;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.TreeNode;

public class P_111 {

    public int minDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final int left = dfs(root.left);
        final int right = dfs(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return 1 + Math.min(left, right);
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
