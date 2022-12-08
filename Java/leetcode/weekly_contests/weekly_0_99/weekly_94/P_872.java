package leetcode.weekly_contests.weekly_0_99.weekly_94;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        final Deque<TreeNode> s1 = new ArrayDeque<>();
        final Deque<TreeNode> s2 = new ArrayDeque<>();
        s1.addFirst(root1);
        s2.addFirst(root2);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (dfs(s1) != dfs(s2)) {
                return false;
            }
        }
        return s1.isEmpty() && s2.isEmpty();
    }

    private static int dfs(Deque<TreeNode> s) {
        while (true) {
            final TreeNode node = s.removeFirst();
            if (node.left != null) { s.addFirst(node.left); }
            if (node.right != null) { s.addFirst(node.right); }
            if (node.left == null && node.right == null) {
                return node.val;
            }
        }
    }

    public boolean leafSimilarBF(TreeNode root1, TreeNode root2) {
        final List<Integer> l1 = new ArrayList<>();
        final List<Integer> l2 = new ArrayList<>();
        leaves(root1, l1);
        leaves(root2, l2);
        return l1.equals(l2);
    }

    private static void leaves(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        leaves(root.left, res);
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        leaves(root.right, res);
    }
}
