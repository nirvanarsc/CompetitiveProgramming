package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.DataStructures.TreeNode;

public class P_1110 {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        final Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        final List<TreeNode> list = new ArrayList<>();
        if (!set.contains(root.val)) { list.add(root); }
        recurse(root, set, list);
        return list;
    }

    private static TreeNode recurse(TreeNode node, Set<Integer> set, List<TreeNode> list) {
        if (node == null) {
            return null;
        }

        node.left = recurse(node.left, set, list);
        node.right = recurse(node.right, set, list);

        if (set.contains(node.val)) {
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
            return null;
        }

        return node;
    }
}
