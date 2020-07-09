package weekly_contests.weekly_46;

import java.util.ArrayDeque;
import java.util.Collections;
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
        int res = 1;
        final Deque<Pair> q = new ArrayDeque<>(Collections.singleton(new Pair(root, 0)));
        while (!q.isEmpty()) {
            if (q.size() >= 2) {
                res = Math.max(res, q.getLast().d - q.getFirst().d + 1);
            }
            for (int size = q.size(); size > 0; size--) {
                final Pair curr = q.removeFirst();
                if (curr.node.left != null) {
                    q.offerLast(new Pair(curr.node.left, (curr.d << 1) + 1));
                }
                if (curr.node.right != null) {
                    q.offerLast(new Pair(curr.node.right, (curr.d << 1) + 2));
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
