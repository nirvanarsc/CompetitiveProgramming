package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.Node;

@SuppressWarnings("ConstantConditions")
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

    public static Node connectBFS(Node root) {
        final Deque<Node> q = new ArrayDeque<>();
        if (root != null) {
            q.offerLast(root);
        }
        while (!q.isEmpty()) {
            Node prev = null;
            for (int level = q.size(); level > 0; level--) {
                final Node curr = q.removeFirst();
                if (curr.left != null) {
                    q.offerLast(curr.left);
                }
                if (curr.right != null) {
                    q.offerLast(curr.right);
                }
                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;
            }
        }
        return root;
    }
}
