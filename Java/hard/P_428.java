package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P_428 {

    static class Node {
        public int val;
        public List<Node> children;

        Node(int _val) {
            val = _val;
        }
    }

    static class Codec {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            final StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        public void serialize(Node root, StringBuilder sb) {
            if (root == null) {
                return;
            }
            sb.append(root.val + ",");
            sb.append(root.children.size() + ",");
            for (Node child : root.children) {
                serialize(child, sb);
            }
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            return deserialize(new LinkedList<>(Arrays.asList(data.split(","))));
        }

        public Node deserialize(Deque<String> q) {
            final String curr = q.removeFirst();
            final String currSize = q.removeFirst();
            final Node root = new Node(Integer.parseInt(curr));
            final List<Node> children = new ArrayList<>();
            for (int i = 0; i < Integer.parseInt(currSize); i++) {
                children.add(deserialize(q));
            }
            root.children = children;
            return root;
        }
    }
}
