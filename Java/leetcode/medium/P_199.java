package leetcode.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_199 {

    public List<Integer> rightSideView(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        final Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offerLast(root);
        }
        while (!queue.isEmpty()) {
            final int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                final TreeNode curr = queue.removeFirst();
                if (i == 0) {
                    res.add(curr.val);
                }
                if (curr.right != null) {
                    queue.offerLast(curr.right);
                }
                if (curr.left != null) {
                    queue.offerLast(curr.left);
                }
            }
        }
        return res;
    }

    public List<Integer> rightSideViewRecursive(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int level) {
        if (curr == null) {
            return;
        }
        if (level == result.size()) {
            result.add(curr.val);
        }

        rightView(curr.right, result, level + 1);
        rightView(curr.left, result, level + 1);
    }
}
