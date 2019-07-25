import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class N_aryTreePostorder {

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
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        final LinkedList<Node> stack = new LinkedList<>(Collections.singletonList(root));
        final LinkedList<Integer> res = new LinkedList<>(Collections.singletonList(root.val));

        while (!stack.isEmpty()) {
            root = stack.pop();
            stack.addAll(root.children);
            for (int i = root.children.size() - 1; i >= 0; i--) {
                res.push(root.children.get(i).val);
            }
        }

        return res;
    }
}
