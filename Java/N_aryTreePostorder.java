import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class N_aryTreePostorder {
    List<Integer> list = new ArrayList<>();

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
    public List<Integer> postorder1(Node root) {
        final LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        final LinkedList<Node> stack = new LinkedList<>(Collections.singletonList(root));

        while (!stack.isEmpty()) {
            root = stack.pop();
            list.push(root.val);
            root.children.forEach(stack::push);
        }

        return list;
    }

    // Recursive
    public List<Integer> postorder2(Node root) {
        if (root == null) {
            return list;
        }

        for (Node node : root.children) {
            postorder2(node);
        }

        list.add(root.val);

        return list;
    }
}
