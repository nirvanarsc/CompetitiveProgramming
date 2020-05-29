package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_207 {

    static class Node {
        int inDegree;
    }

    // Topological sort - Kahn's algorithm
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        final Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            nodes.put(i, new Node());
        }
        final Map<Node, List<Node>> g = new HashMap<>();
        for (int[] pq : prerequisites) {
            g.computeIfAbsent(nodes.get(pq[1]), v -> new ArrayList<>()).add(nodes.get(pq[0]));
            nodes.get(pq[0]).inDegree++;
        }
        final Deque<Node> q = new ArrayDeque<>();
        for (Node n : nodes.values()) {
            if (n.inDegree == 0) {
                q.offerLast(n);
            }
        }
        int visited = 0;
        while (!q.isEmpty()) {
            final Node node = q.removeFirst();
            visited++;
            for (Node n : g.getOrDefault(node, Collections.emptyList())) {
                if (--n.inDegree == 0) {
                    q.offerLast(n);
                }
            }
        }
        return visited == numCourses;
    }
}
