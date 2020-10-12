package leetcode.biweekly_contests.biweekly_29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P_1494 {

    static class Node {
        int inDegree;
    }

    // Greedy is wrong -> requires bitmask dp
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        final Map<Integer, Node> nodes = new HashMap<>();
        final Map<Node, List<Node>> g = new HashMap<>();
        final Comparator<Node> comp = (a, b) ->
                Integer.compare(g.getOrDefault(b, Collections.emptyList()).size(),
                                g.getOrDefault(a, Collections.emptyList()).size());
        final PriorityQueue<Node> q = new PriorityQueue<>(comp);
        for (int i = 1; i <= n; i++) {
            nodes.put(i, new Node());
        }
        for (int[] pq : dependencies) {
            g.computeIfAbsent(nodes.get(pq[0]), v -> new ArrayList<>()).add(nodes.get(pq[1]));
            nodes.get(pq[1]).inDegree++;
        }
        for (Node node : nodes.values()) {
            if (node.inDegree == 0) {
                q.offer(node);
            }
        }
        int level;
        for (level = 0; !q.isEmpty(); level++) {
            final PriorityQueue<Node> nextPq = new PriorityQueue<>(comp);
            for (int size = Math.min(k, q.size()); size > 0; size--) {
                final Node node = q.remove();
                for (Node next : g.getOrDefault(node, Collections.emptyList())) {
                    if (--next.inDegree == 0) {
                        nextPq.offer(next);
                    }
                }
            }
            q.addAll(nextPq);
        }
        return level;
    }
}
