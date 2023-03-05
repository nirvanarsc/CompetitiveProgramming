package leetcode.weekly_contests.weekly_300_399.weekly_335;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_2 {

    public long kthLargestLevelSum(TreeNode root, int k) {
        final Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offerLast(root);
        final List<Long> levels = new ArrayList<>();
        while (!dq.isEmpty()) {
            long curr = 0;
            for (int size = dq.size(); size > 0; size--) {
                final TreeNode u = dq.removeFirst();
                if (u.left != null) { dq.offerLast(u.left); }
                if (u.right != null) { dq.offerLast(u.right); }
                curr += u.val;
            }
            levels.add(curr);
        }
        levels.sort(Comparator.reverseOrder());
        return levels.size() < k ? -1 : levels.get(k - 1);
    }
}
