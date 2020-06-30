package medium;

public class P_426 {

    private static class Node {
        public int val;
        public Node left;
        public Node right;
    }

    Node prev;
    Node first;

    @SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        prev.right = first;
        first.left = prev;
        return first;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev == null) {
            first = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        dfs(root.right);
    }
}
