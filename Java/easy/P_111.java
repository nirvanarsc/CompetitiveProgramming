package easy;

import java.util.Deque;
import java.util.LinkedList;

import utils.DataStructures.TreeNode;

public class P_111 {

    public int minDepth(TreeNode root) {
        return getDepth(root, 0);
    }

    public int getDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        final int left = getDepth(root.left, depth);
        final int right = getDepth(root.right, depth);

        if (left == 0 || right == 0) {
            return left + right + 1;
        }

        return 1 + Math.min(left, right);
    }

    public int minDepthBFS(TreeNode root) {
        final Deque<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        if (root != null) {
            queue.offerLast(root);
            depth++;
        }
        while (!queue.isEmpty()) {
            int level = queue.size();
            while (level-- > 0) {
                final TreeNode curr = queue.removeFirst();
                if (curr.left == null && curr.right == null) {
                    return depth;
                }
                if (curr.right != null) {
                    queue.offerLast(curr.right);
                }
                if (curr.left != null) {
                    queue.offerLast(curr.left);
                }
            }
            depth++;
        }

        return depth;
    }
}
