package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P_429 {

    private static class Node {
        int val;
        List<Node> children;
    }

    public List<List<Integer>> levelOrder(Node root) {
        final List<List<Integer>> res = new ArrayList<>();
        final Deque<Node> dq = new ArrayDeque<>();
        if (root != null) {
            dq.offerLast(root);
        }
        while (!dq.isEmpty()) {
            final List<Integer> level = new ArrayList<>();
            for (int size = dq.size(); size > 0; size--) {
                final Node curr = dq.removeFirst();
                level.add(curr.val);
                for (Node next : curr.children) {
                    dq.offerLast(next);
                }
            }
            res.add(level);
        }
        return res;
    }
}
