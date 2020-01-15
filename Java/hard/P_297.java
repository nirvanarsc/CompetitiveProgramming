package hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import utils.DataStructures.TreeNode;

public class P_297 {

    public static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            final StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        public void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#,");
                return;
            }
            sb.append(root.val + ",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return deserialize(new LinkedList<>(Arrays.asList(data.split(","))));
        }

        public TreeNode deserialize(Deque<String> q) {
            final String curr = q.removeFirst();
            if ("#".equals(curr)) {
                return null;
            }
            final TreeNode root = new TreeNode(Integer.parseInt(curr));
            root.left = deserialize(q);
            root.right = deserialize(q);
            return root;
        }
    }
}
