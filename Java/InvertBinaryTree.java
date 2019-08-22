import java.util.LinkedList;
import java.util.Queue;

import org.jetbrains.annotations.Nullable;

public class InvertBinaryTree {
    private static class TreeNode {
        int val;
        @Nullable TreeNode left;
        @Nullable TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public @Nullable TreeNode invertTree(@Nullable TreeNode root) {
        if (root == null) { return null; }
        final TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    public @Nullable TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) { queue.offer(node.left); }
            if (node.right != null) { queue.offer(node.right); }
        }
        return root;
    }
}
