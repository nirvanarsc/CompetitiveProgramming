package leetcode.weekly_contests.weekly_92;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_865 {

    static class Pair {
        int depth;
        TreeNode ans;

        Pair(int depth, TreeNode ans) {
            this.depth = depth;
            this.ans = ans;
        }
    }

    public TreeNode subtreeWithAllDeepestDFS(TreeNode root) {
        return dfs(root).ans;
    }

    private static Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(0, null);
        }
        final Pair left = dfs(root.left);
        final Pair right = dfs(root.right);
        if (left.depth == right.depth) {
            return new Pair(left.depth + 1, root);
        }
        if (left.depth > right.depth) {
            return new Pair(left.depth + 1, left.ans);
        }
        return new Pair(right.depth + 1, right.ans);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        final Deque<TreeNode[]> dq = new ArrayDeque<>();
        final List<Integer> leaves = new ArrayList<>(2);
        final int[] depths = new int[505];
        final int[] parents = new int[505];
        final TreeNode[] map = new TreeNode[505];
        dq.offerLast(new TreeNode[] { root, new TreeNode(-1) });
        for (int level = 0; !dq.isEmpty(); level++) {
            leaves.clear();
            final int size = dq.size();
            for (int i = 0; i < size; i++) {
                final TreeNode[] curr = dq.removeFirst();
                final TreeNode node = curr[0];
                final TreeNode parent = curr[1];
                map[node.val] = node;
                depths[node.val] = level;
                parents[node.val] = parent.val;
                if (node.left != null) {
                    dq.offerLast(new TreeNode[] { node.left, node });
                }
                if (node.right != null) {
                    dq.offerLast(new TreeNode[] { node.right, node });
                }
                if (i == 0) {
                    leaves.add(node.val);
                }
                if (i == size - 1 && size > 1) {
                    leaves.add(node.val);
                }
            }
        }
        if (leaves.size() == 1) {
            return map[leaves.get(0)];
        }
        int l = leaves.get(0);
        int r = leaves.get(1);
        while (depths[l] < depths[r]) { l = parents[l]; }
        while (depths[r] < depths[l]) { r = parents[r]; }
        while (l != r) {
            l = parents[l];
            r = parents[r];
        }
        return map[l];
    }
}
