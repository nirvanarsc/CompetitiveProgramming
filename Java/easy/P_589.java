package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P_589 {

    private static class Node {
        public int val;
        public List<Node> children;
    }

    public List<Integer> preorder(Node root) {
        final List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private static void dfs(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        for (Node next : node.children) {
            dfs(next, res);
        }
    }

    public List<Integer> preorderIterative(Node root) {
        final List<Integer> res = new ArrayList<>();
        final Deque<Node> stack = new ArrayDeque<>();
        if (root != null) {
            stack.addFirst(root);
        }
        while (!stack.isEmpty()) {
            final Node curr = stack.removeFirst();
            res.add(curr.val);
            for (int i = curr.children.size() - 1; i >= 0; i--) {
                stack.addFirst(curr.children.get(i));
            }
        }
        return res;
    }
}
