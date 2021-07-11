package leetcode.weekly_contests.weekly_249;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.DataStructures.TreeNode;

@SuppressWarnings("ReturnOfNull")
public class P_4 {

    public TreeNode canMerge(List<TreeNode> trees) {
        final Map<Integer, TreeNode> map = new HashMap<>();
        final Set<Integer> set = new HashSet<>();
        for (TreeNode tree : trees) {
            map.put(tree.val, tree);
            addLeaves(tree, set, true);
        }
        for (TreeNode tree : trees) {
            if (!set.contains(tree.val)) {
                canMerge(tree, map, true);
                return map.size() == 1 && isValidBST(tree, new TreeNode((int) -1e9), new TreeNode((int) 1e9))
                       ? tree
                       : null;
            }
        }
        return null;
    }

    private static void addLeaves(TreeNode tree, Set<Integer> set, boolean root) {
        if (tree == null) {
            return;
        }
        if (tree.left == null && tree.right == null && !root) {
            set.add(tree.val);
        }
        addLeaves(tree.left, set, false);
        addLeaves(tree.right, set, false);
    }

    private static void canMerge(TreeNode tree, Map<Integer, TreeNode> map, boolean root) {
        if (tree == null) {
            return;
        }
        if (tree.left == null && tree.right == null && map.containsKey(tree.val) && !root) {
            tree.left = map.get(tree.val).left;
            tree.right = map.remove(tree.val).right;
        }
        canMerge(tree.left, map, false);
        canMerge(tree.right, map, false);
    }

    private static boolean isValidBST(TreeNode node, TreeNode left, TreeNode right) {
        if (node == null) {
            return true;
        }
        if (left != null && node.val <= left.val) {
            return false;
        }
        if (right != null && node.val >= right.val) {
            return false;
        }
        return isValidBST(node.left, left, node) && isValidBST(node.right, node, right);
    }
}
