package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_199 {

    public List<Integer> rightSideView(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        final Deque<TreeNode> queue = new ArrayDeque<>();
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

    public List<Integer> rightSideViewDfs(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    public void dfs(TreeNode node, List<Integer> res, int depth) {
        if (node == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(node.val);
        }
        dfs(node.right, res, depth + 1);
        dfs(node.left, res, depth + 1);
    }
}
