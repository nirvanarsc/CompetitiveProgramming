package leetcode.weekly_contests.weekly_100_199.weekly_115;

import java.util.Collections;
import java.util.LinkedList;

import utils.DataStructures.TreeNode;

public class P_958 {

    public boolean isCompleteTreeBFS(TreeNode root) {
        final LinkedList<TreeNode> queue = new LinkedList<>(Collections.singletonList(root));
        while (queue.peekFirst() != null) {
            final TreeNode curr = queue.remove();
            queue.add(curr.left);
            queue.add(curr.right);
        }
        while (!queue.isEmpty() && queue.peekFirst() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }

    public boolean isCompleteTree(TreeNode root) {
        return isCompleteTree(root, 0, countNodes(root));
    }

    private static boolean isCompleteTree(TreeNode root, int i, int n) {
        if (root == null) {
            return true;
        }
        if (i >= n) {
            return false;
        }
        return isCompleteTree(root.left, 2 * i + 1, n) && isCompleteTree(root.right, 2 * i + 2, n);
    }

    private static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
