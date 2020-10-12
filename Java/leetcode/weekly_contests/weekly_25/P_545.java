package leetcode.weekly_contests.weekly_25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.DataStructures.TreeNode;

@SuppressWarnings("ReplaceNullCheck")
public class P_545 {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) { return Collections.emptyList(); }
        final List<Integer> res = new ArrayList<>(Collections.singleton(root.val));
        getLeft(root.left, res);
        getLeaves(root.left, res);
        getLeaves(root.right, res);
        getRight(root.right, res);
        return res;
    }

    private static void getLeaves(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        getLeaves(node.left, list);
        if (node.left == null && node.right == null) {
            list.add(node.val);
        }
        getLeaves(node.right, list);
    }

    private static void getLeft(TreeNode node, List<Integer> list) {
        if (node == null || node.left == null && node.right == null) {
            return;
        }
        list.add(node.val);
        if (node.left != null) {
            getLeft(node.left, list);
        } else {
            getLeft(node.right, list);
        }
    }

    private static void getRight(TreeNode node, List<Integer> list) {
        if (node == null || node.left == null && node.right == null) {
            return;
        }
        if (node.right != null) {
            getRight(node.right, list);
        } else {
            getRight(node.left, list);
        }
        list.add(node.val);
    }
}
