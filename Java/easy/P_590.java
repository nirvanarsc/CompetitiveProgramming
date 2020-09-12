package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class P_590 {

    private static class Node {
        public int val;
        public List<Node> children;
    }

    public List<Integer> postorder(Node root) {
        final List<Integer> res = new ArrayList<>();
        final Deque<Node> stack = new ArrayDeque<>();
        if (root != null) {
            stack.addFirst(root);
        }
        while (!stack.isEmpty()) {
            final Node curr = stack.removeFirst();
            res.add(curr.val);
            for (Node n : curr.children) {
                stack.addFirst(n);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
