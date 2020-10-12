package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

import utils.DataStructures.Node;

public class P_116 {

    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public static Node connectIterative(Node root) {
        final Deque<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offerLast(root);
        }
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Node prev = null;
            while (levelSize-- > 0) {
                final Node node = queue.removeFirst();
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }
        }
        return root;
    }
}
