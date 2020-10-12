package leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_685 {

    static class Node {
        int node;
        Set<Integer> seen;

        Node(int n, Set<Integer> s) {
            node = n;
            seen = s;
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        final int n = edges.length;
        final Map<Integer, Integer> parent = new HashMap<>();
        final List<int[]> candidates = new ArrayList<>();
        for (int[] edge : edges) {
            if (parent.containsKey(edge[1])) {
                candidates.add(new int[] { parent.get(edge[1]), edge[1] });
                candidates.add(edge);
            } else {
                parent.put(edge[1], edge[0]);
            }
        }
        final int root = orbit(1, parent).node;
        if (candidates.isEmpty()) {
            final Set<Integer> cycle = orbit(root, parent).seen;
            int[] ans = { 0, 0 };
            for (int[] edge : edges) {
                if (cycle.contains(edge[0]) && cycle.contains(edge[1])) {
                    ans = edge;
                }
            }
            return ans;
        }
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (Map.Entry<Integer, Integer> e : parent.entrySet()) {
            g.computeIfAbsent(e.getValue(), v -> new ArrayList<>()).add(e.getKey());
        }
        final boolean[] seen = new boolean[n + 1];
        seen[0] = true;
        final Deque<Integer> stack = new ArrayDeque<>(Collections.singleton(root));
        while (!stack.isEmpty()) {
            final int node = stack.removeFirst();
            if (!seen[node]) {
                seen[node] = true;
                for (int next : g.getOrDefault(node, Collections.emptyList())) {
                    stack.addFirst(next);
                }
            }
        }
        for (boolean b : seen) {
            if (!b) {
                return candidates.get(0);
            }
        }
        return candidates.get(1);
    }

    public Node orbit(int node, Map<Integer, Integer> parent) {
        final Set<Integer> seen = new HashSet<>();
        while (parent.containsKey(node) && !seen.contains(node)) {
            seen.add(node);
            node = parent.get(node);
        }
        return new Node(node, seen);
    }
}
