package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_95 {

    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    public List<TreeNode> dfs(int start, int n) {
        if (n == 0) {
            return Collections.singletonList(null);
        }
        final List<TreeNode> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final List<TreeNode> leftNodes = dfs(start, i);
            final List<TreeNode> rightNodes = dfs(start + i + 1, n - 1 - i);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    final TreeNode treeNode = new TreeNode(start + i);
                    treeNode.left = left;
                    treeNode.right = right;
                    res.add(treeNode);
                }
            }
        }
        return res;
    }
}
