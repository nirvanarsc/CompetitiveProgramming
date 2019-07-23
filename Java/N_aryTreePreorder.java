import java.util.ArrayList;
import java.util.List;

public class N_aryTreePreorder {

    private static final class Node {
        public int val;
        public List<Node> children;

        private Node() {}

        private Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        final List<Integer> result = new ArrayList<>();
        while (!root.children.isEmpty()) {

        }
        return result;
    }
}
