package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P_429 {

    private static class Node {
        public int val;
        public List<Node> children;
    }

    public List<List<Integer>> levelOrder(Node root) {
        final List<List<Integer>> res = new ArrayList<>();
        final Deque<Node> q = new ArrayDeque<>();
        if (root != null) {
            q.offerLast(root);
        }
        while (!q.isEmpty()) {
            final List<Integer> currLevel = new ArrayList<>();
            for (int size = q.size(); size > 0; size--) {
                final Node curr = q.removeFirst();
                currLevel.add(curr.val);
                for (Node next : curr.children) {
                    q.offerLast(next);
                }
            }
            res.add(currLevel);
        }
        return res;
    }
}
