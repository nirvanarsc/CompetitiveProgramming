package weekly_contests.weekly_144;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.DataStructures.TreeNode;

public class P_1110 {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        final List<TreeNode> res = new ArrayList<>();
        final Set<Integer> del = new HashSet<>();
        for (int num : to_delete) {
            del.add(num);
        }
        if (!del.contains(root.val)) { res.add(root); }
        recurse(root, del, res);
        return res;
    }

    private static TreeNode recurse(TreeNode node, Set<Integer> del, List<TreeNode> res) {
        if (node == null) {
            return null;
        }

        node.left = recurse(node.left, del, res);
        node.right = recurse(node.right, del, res);
        if (del.contains(node.val)) {
            if (node.left != null) {
                res.add(node.left);
            }
            if (node.right != null) {
                res.add(node.right);
            }
            return null;
        }

        return node;
    }
}
