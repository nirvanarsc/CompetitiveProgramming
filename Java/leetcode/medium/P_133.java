package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ConstantConditions")
public class P_133 {

    private static class Node {
        public int val;
        public List<Node> neighbors = new ArrayList<>();

        Node(int val) {
            this.val = val;
        }
    }

    public Node cloneGraph(Node node) {
        final Map<Node, Node> clone = new HashMap<>();
        final boolean[] seen = new boolean[101];
        final Deque<Node> q = new ArrayDeque<>();
        if (node != null) {
            q.offerLast(node);
            seen[node.val] = true;
            clone.put(node, new Node(node.val));
        }
        while (!q.isEmpty()) {
            final Node curr = q.removeFirst();
            for (Node next : curr.neighbors) {
                if (!seen[next.val]) {
                    seen[next.val] = true;
                    clone.put(next, new Node(next.val));
                    q.offerLast(next);
                }
                clone.get(curr).neighbors.add(clone.get(next));
            }
        }
        return clone.get(node);
    }
}
