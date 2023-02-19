package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        final List<List<Integer>> res = new ArrayList<>();
        final Deque<TreeNode> dq = new ArrayDeque<>();
        if (root != null) {
            dq.offerLast(root);
        }
        for (int level = 0; !dq.isEmpty(); level++) {
            final List<Integer> curr = new ArrayList<>();
            for (int size = dq.size(); size > 0; size--) {
                final TreeNode u = dq.removeFirst();
                curr.add(u.val);
                if (u.left != null) { dq.offerLast(u.left); }
                if (u.right != null) { dq.offerLast(u.right); }
            }
            if (level % 2 != 0) {
                Collections.reverse(curr);
            }
            res.add(curr);
        }
        return res;
    }
}
