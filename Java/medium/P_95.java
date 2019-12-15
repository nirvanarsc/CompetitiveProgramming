package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_95 {

    public List<TreeNode> generateTrees(int n) {
        return n > 0 ? recurse(1, n) : Collections.emptyList();
    }

    public List<TreeNode> recurse(int start, int n) {
        final List<TreeNode> res = new ArrayList<>();
        if (n == 0) {
            res.add(null);
        }

        for (int i = 0; i < n; i++) {
            final List<TreeNode> leftNodes = recurse(start, i);
            final List<TreeNode> rightNodes = recurse(start + i + 1, n - 1 - i);
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
