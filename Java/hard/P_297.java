package hard;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull", "InnerClassMayBeStatic" })
public class P_297 {

    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            final StringBuilder sb = new StringBuilder();
            dfs(root, sb);
            return sb.toString();
        }

        private void dfs(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("#,");
                return;
            }
            sb.append(node.val + ",");
            dfs(node.left, sb);
            dfs(node.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return build(data.split(","), new int[] { 0 });
        }

        private TreeNode build(String[] arr, int[] idx) {
            if (idx[0] == arr.length) {
                return null;
            }
            final String curr = arr[idx[0]++];
            if ("#".equals(curr)) {
                return null;
            }
            final TreeNode root = new TreeNode(Integer.parseInt(curr));
            root.left = build(arr, idx);
            root.right = build(arr, idx);
            return root;
        }
    }
}
