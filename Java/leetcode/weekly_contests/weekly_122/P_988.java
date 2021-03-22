package leetcode.weekly_contests.weekly_122;

import utils.DataStructures.TreeNode;

public class P_988 {

    public String smallestFromLeaf(TreeNode root) {
        final String[] res = { "" };
        dfs(root, new StringBuilder(), res);
        return res[0];
    }

    private static void dfs(TreeNode node, StringBuilder sb, String[] res) {
        if (node == null) {
            return;
        }
        sb.append((char) (node.val + 'a'));
        if (node.left == null && node.right == null) {
            final String curr = new StringBuilder(sb).reverse().toString();
            if (res[0].isEmpty() || res[0].compareTo(curr) > 0) {
                res[0] = curr;
            }
        }
        dfs(node.left, sb, res);
        dfs(node.right, sb, res);
        sb.deleteCharAt(sb.length() - 1);
    }
}
