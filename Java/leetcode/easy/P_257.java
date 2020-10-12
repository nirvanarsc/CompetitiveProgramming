package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        final List<String> res = new ArrayList<>();
        dfs(root, res, new StringBuilder());
        return res;
    }

    private static void dfs(TreeNode node, List<String> res, StringBuilder sb) {
        if (node == null) {
            return;
        }
        final boolean isLeaf = node.left == null && node.right == null;
        final String key = isLeaf ? String.valueOf(node.val) : node.val + "->";
        sb.append(key);
        if (isLeaf) {
            res.add(new String(sb));
        }
        dfs(node.left, res, sb);
        dfs(node.right, res, sb);
        sb.delete(sb.length() - key.length(), sb.length());
    }
}
