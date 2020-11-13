package leetcode.medium;

import utils.DataStructures.Node;

public class P_117 {

    public Node connect(Node root) {
        final Node res = root;
        while (root != null) {
            final Node level = new Node(0);
            Node curr = level;
            while (root != null) {
                if (root.left != null) {
                    curr.next = root.left;
                    curr = curr.next;
                }
                if (root.right != null) {
                    curr.next = root.right;
                    curr = curr.next;
                }
                root = root.next;
            }
            root = level.next;
        }
        return res;
    }

    public Node connectBFS(Node root) {
        return P_116.connectBFS(root);
    }
}
