import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class N_aryTreePreorder {
    List<Integer> list = new ArrayList<>();

    private static final class Node {
        public int val;
        public List<Node> children;

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

        final LinkedList<Node> stack = new LinkedList<>(Collections.singletonList(root));

        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            stack.addAll(0, root.children);
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
