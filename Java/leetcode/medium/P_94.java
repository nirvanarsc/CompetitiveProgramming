package leetcode.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        final Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            } else {
                curr = stack.removeFirst();
                res.add(curr.val);
                curr = curr.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversalR(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    public List<Integer> morris(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        TreeNode prev, curr = root;

        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                // Find predecessor
                prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                // Establish a link from predecessor to current
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else { // We have traversed the left tree. Remove link from predecessor to current
                    prev.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return res;
    }
}
