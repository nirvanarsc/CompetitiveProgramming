package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P_210 {

    public static final int[] EMPTY_ARRAY = {};

    static class Node {
        int courseVal;
        int inDegree;
        List<Node> adjacent = new ArrayList<>();

        Node(int courseVal) {
            this.courseVal = courseVal;
        }
    }

    // Topological sort - Kahn's algorithm
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        final Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            nodes.put(i, new Node(i));
        }

        for (int[] pre : prerequisites) {
            final Node node = nodes.get(pre[0]);
            node.inDegree++;
            node.adjacent.add(nodes.get(pre[1]));
            nodes.get(pre[1]).adjacent.add(node);
        }

        final Deque<Node> queue = new LinkedList<>();

        for (Node node : nodes.values()) {
            if (node.inDegree == 0) {
                queue.offerLast(node);
            }
        }

        final int[] res = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            final Node curr = queue.removeFirst();
            res[idx++] = curr.courseVal;
            numCourses--;
            for (Node adjacent : curr.adjacent) {
                if (--adjacent.inDegree == 0) {
                    queue.offerLast(adjacent);
                }
            }
        }

        return numCourses == 0 ? res : EMPTY_ARRAY;
    }
}
