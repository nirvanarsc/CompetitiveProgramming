import static java.util.Collections.singletonList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N_aryTreePreorder {
    public List<Integer> list = new ArrayList<>();

    private static final class Node {
        public int val;
        public List<Node> children;

        private Node() {}

        private Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // Iterative
    public List<Integer> preorder1(Node root) {
        final List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        final LinkedList<Node> stack = new LinkedList<>(singletonList(root));

        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--) {
                stack.push(root.children.get(i));
            }
        }

        return list;
    }

    // Recursive
    public List<Integer> preorder2(Node root) {
        if (root == null) {
            return list;
        }

        list.add(root.val);
        for (Node node : root.children) {
            preorder2(node);
        }

        return list;
    }
}
