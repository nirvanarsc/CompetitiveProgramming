package leetcode.weekly_contests.weekly_0_99.weekly_37;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.TreeNode;

public class P_623 {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            final TreeNode res = new TreeNode(v);
            res.left = root;
            return res;
        }
        final Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offerLast(root);
        for (int i = 1; i < d; i++) {
            for (int size = dq.size(); size > 0; size--) {
                final TreeNode curr = dq.removeFirst();
                if (i == d - 1) {
                    final TreeNode temp = curr.left;
                    final TreeNode insert = new TreeNode(v);
                    insert.left = temp;
                    curr.left = insert;
                } else if (curr.left != null) {
                    dq.offerLast(curr.left);
                }
                if (i == d - 1) {
                    final TreeNode temp = curr.right;
                    final TreeNode insert = new TreeNode(v);
                    insert.right = temp;
                    curr.right = insert;
                } else if (curr.right != null) {
                    dq.offerLast(curr.right);
                }
            }
        }
        return root;
    }
}
