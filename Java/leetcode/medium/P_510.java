package leetcode.medium;

public class P_510 {

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    @SuppressWarnings("ConstantConditions")
    public Node inorderSuccessor(Node node) {
        final int curr = node.val;
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
        } else {
            node = node.parent;
            while (node != null && node.val < curr) {
                node = node.parent;
            }
        }
        return node;
    }
}
