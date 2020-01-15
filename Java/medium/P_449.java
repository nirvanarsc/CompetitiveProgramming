package medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import utils.DataStructures.TreeNode;

public class P_449 {

    public static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            final StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        public void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return;
            }
            sb.append(root.val + ",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            final Deque<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public TreeNode deserialize(Deque<String> q, int lower, int upper) {
            if (q.isEmpty()) {
                return null;
            }
            final int val = Integer.parseInt(q.peekFirst());
            if (val < lower || val > upper) {
                return null;
            }
            q.poll();
            final TreeNode root = new TreeNode(val);
            root.left = deserialize(q, lower, val);
            root.right = deserialize(q, val, upper);
            return root;
        }
    }
}
