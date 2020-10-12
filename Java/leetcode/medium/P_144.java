package leetcode.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_144 {

    public List<Integer> preorderIterative(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        final Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.addFirst(curr);
                res.add(curr.val);
                curr = curr.left;
            } else {
                curr = stack.removeFirst();
                curr = curr.right;
            }
        }

        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        final List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private static void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }

}
