package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.DataStructures.TreeNode;

public class P_366 {

    public List<List<Integer>> findLeaves(TreeNode root) {
        final List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }

    private static int height(TreeNode node, List<List<Integer>> res) {
        if (null == node) {
            return -1;
        }
        final int level = 1 + Math.max(height(node.left, res), height(node.right, res));
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        return level;
    }

    public List<List<Integer>> findLeavesTopSort(TreeNode root) {
        final Map<TreeNode, Integer> degree = new HashMap<>();
        final Map<TreeNode, List<TreeNode>> g = new HashMap<>();
        final Deque<TreeNode> q = new ArrayDeque<>();
        if (root != null) {
            q.offerLast(root);
        }
        while (!q.isEmpty()) {
            final TreeNode curr = q.removeFirst();
            degree.put(curr, 0);
            if (curr.left != null) {
                g.computeIfAbsent(curr.left, v -> new ArrayList<>()).add(curr);
                degree.merge(curr, 1, Integer::sum);
                q.offerLast(curr.left);
            }
            if (curr.right != null) {
                g.computeIfAbsent(curr.right, v -> new ArrayList<>()).add(curr);
                degree.merge(curr, 1, Integer::sum);
                q.offerLast(curr.right);
            }
        }
        final Deque<TreeNode> topSort = new ArrayDeque<>();
        for (Map.Entry<TreeNode, Integer> e : degree.entrySet()) {
            if (e.getValue() == 0) {
                topSort.offerLast(e.getKey());
            }
        }
        final List<List<Integer>> res = new ArrayList<>();
        while (!topSort.isEmpty()) {
            final List<Integer> level = new ArrayList<>();
            for (int size = topSort.size(); size > 0; size--) {
                final TreeNode curr = topSort.removeFirst();
                level.add(curr.val);
                for (TreeNode next : g.getOrDefault(curr, Collections.emptyList())) {
                    if (degree.merge(next, -1, Integer::sum) == 0) {
                        topSort.offerLast(next);
                    }
                }
            }
            res.add(level);
        }
        return res;
    }
}
