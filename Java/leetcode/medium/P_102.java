package leetcode.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> res = new ArrayList<>();
        final Deque<TreeNode> dq = new LinkedList<>();
        if (root != null) {
            dq.offerFirst(root);
        }
        while (!dq.isEmpty()) {
            final List<Integer> level = new ArrayList<>();
            for (int size = dq.size(); size > 0; size--) {
                final TreeNode curr = dq.removeLast();
                level.add(curr.val);
                if (curr.left != null) {
                    dq.offerFirst(curr.left);
                }
                if (curr.right != null) {
                    dq.offerFirst(curr.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
