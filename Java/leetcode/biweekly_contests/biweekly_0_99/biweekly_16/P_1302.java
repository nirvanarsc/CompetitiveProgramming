package leetcode.biweekly_contests.biweekly_0_99.biweekly_16;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.TreeNode;

public class P_1302 {

    public int deepestLeavesSum(TreeNode root) {
        final Deque<TreeNode> dq = new ArrayDeque<>();
        int res = 0;
        dq.offerLast(root);
        while (!dq.isEmpty()) {
            res = 0;
            for (int size = dq.size(); size > 0; size--) {
                final TreeNode curr = dq.removeFirst();
                res += curr.val;
                if (curr.left != null) {
                    dq.offerLast(curr.left);
                }
                if (curr.right != null) {
                    dq.offerLast(curr.right);
                }
            }
        }
        return res;
    }
}
