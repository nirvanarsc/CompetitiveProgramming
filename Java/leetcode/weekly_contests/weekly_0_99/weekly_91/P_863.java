package leetcode.weekly_contests.weekly_0_99.weekly_91;

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

public class P_863 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        final Map<Integer, List<Integer>> g = buildGraph(root);
        final Deque<Integer> q = new ArrayDeque<>(Collections.singleton(target.val));
        final Set<Integer> visited = new HashSet<>();
        while (K > 0) {
            for (int i = q.size(); i > 0; i--) {
                final Integer curr = q.removeFirst();
                visited.add(curr);
                for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                    if (!visited.contains(next)) {
                        q.offerLast(next);
                    }
                }
            }
            K--;
        }
        return new ArrayList<>(q);
    }

    private static Map<Integer, List<Integer>> buildGraph(TreeNode root) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        final Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
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
        }
        return g;
    }
}
