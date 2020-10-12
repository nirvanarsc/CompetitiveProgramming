package leetcode.weekly_contests.weekly_62;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.DataStructures.TreeNode;

public class P_742 {

    public int findClosestLeaf(TreeNode root, int k) {
        final Set<Integer> leaves = new HashSet<>();
        final Map<Integer, List<Integer>> g = buildGraph(root, leaves);
        if (leaves.contains(k)) {
            return k;
        }
        final Deque<Integer> q = new ArrayDeque<>(Collections.singleton(k));
        final Set<Integer> visited = new HashSet<>(Collections.singleton(k));
        while (!q.isEmpty()) {
            final Integer curr = q.removeFirst();
            for (int n : g.getOrDefault(curr, Collections.emptyList())) {
                if (visited.add(n)) {
                    q.offerLast(n);
                }
                if (leaves.contains(n)) {
                    return n;
                }
            }
        }
        return -1;
    }

    private static Map<Integer, List<Integer>> buildGraph(TreeNode root, Set<Integer> leaves) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        final Deque<TreeNode> q = new ArrayDeque<>(Collections.singleton(root));
        while (!q.isEmpty()) {
            final TreeNode curr = q.removeFirst();
            if (curr.left != null) {
                q.offerLast(curr.left);
                g.computeIfAbsent(curr.left.val, v -> new ArrayList<>()).add(curr.val);
                g.computeIfAbsent(curr.val, v -> new ArrayList<>()).add(curr.left.val);
            }
            if (curr.right != null) {
                q.offerLast(curr.right);
                g.computeIfAbsent(curr.right.val, v -> new ArrayList<>()).add(curr.val);
                g.computeIfAbsent(curr.val, v -> new ArrayList<>()).add(curr.right.val);
            }
            if (curr.left == curr.right) {
                leaves.add(curr.val);
            }
        }
        return g;
    }
}
