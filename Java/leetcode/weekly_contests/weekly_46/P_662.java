package leetcode.weekly_contests.weekly_46;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.TreeNode;

public class P_662 {

    private static class Pair {
        TreeNode node;
        int d;

        Pair(TreeNode node, int d) {
            this.node = node;
            this.d = d;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        final Deque<Pair> dq = new ArrayDeque<>();
        dq.offerLast(new Pair(root, 0));
        while (!dq.isEmpty()) {
            res = Math.max(res, dq.getLast().d - dq.getFirst().d + 1);
            for (int size = dq.size(); size > 0; size--) {
                final Pair curr = dq.removeFirst();
                final TreeNode u = curr.node;
                final int d = curr.d;
                if (u.left != null) {
                    dq.offerLast(new Pair(u.left, 2 * d + 1));
                }
                if (u.right != null) {
                    dq.offerLast(new Pair(u.right, 2 * d + 2));
                }
            }
        }
        return res;
    }

    public int widthOfBinaryTreeDFS(TreeNode root) {
        final int[] ans = { 0 };
        dfs(root, 0, 0, new HashMap<>(), ans);
        return ans[0];
    }

    public void dfs(TreeNode root, int depth, int pos, Map<Integer, Integer> left, int[] ans) {
        if (root == null) {
            return;
        }
        left.putIfAbsent(depth, pos);
        ans[0] = Math.max(ans[0], pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos, left, ans);
        dfs(root.right, depth + 1, 2 * pos + 1, left, ans);
    }
}
