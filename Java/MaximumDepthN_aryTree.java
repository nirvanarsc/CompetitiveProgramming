import java.util.List;

public class MaximumDepthN_aryTree {

    static class Node {
        public int val;
        public List<Node> children;

        Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // Recursive DFS
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        for (Node child : root.children) {
            maxDepth = Math.max(maxDepth, maxDepth(child));
        }
        return maxDepth + 1;
    }
}
