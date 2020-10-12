package leetcode.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P_133 {

    private static class Node {
        public int val;
        public List<Node> neighbors;

        Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        final Map<Node, Node> map = new HashMap<>();
        final Deque<Node> queue = new LinkedList<>();

        if (node != null) {
            queue.offerLast(node);
            map.put(node, new Node(node.val, new ArrayList<>()));
        }
        while (!queue.isEmpty()) {
            final Node curr = queue.removeFirst();

            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offerLast(neighbor);
                }

                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}
