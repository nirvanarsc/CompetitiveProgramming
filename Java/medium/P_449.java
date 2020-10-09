package medium;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull", "InnerClassMayBeStatic" })
public class P_449 {

    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            final StringBuilder sb = new StringBuilder();
            dfs(root, sb);
            return sb.toString();
        }

        private void dfs(TreeNode node, StringBuilder sb) {
            if (node == null) {
                return;
            }
            sb.append(node.val + ",");
            dfs(node.left, sb);
            dfs(node.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            return build(data.split(","), new int[] { 0 }, 0, 10000);
        }

        private TreeNode build(String[] arr, int[] idx, int lower, int upper) {
            if (idx[0] == arr.length) {
                return null;
            }
            final int curr = Integer.parseInt(arr[idx[0]]);
            if (curr < lower || curr > upper) {
                return null;
            }
            idx[0]++;
            final TreeNode root = new TreeNode(curr);
            root.left = build(arr, idx, lower, curr);
            root.right = build(arr, idx, curr, upper);
            return root;
        }
    }
}
