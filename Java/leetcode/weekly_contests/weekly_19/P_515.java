package leetcode.weekly_contests.weekly_19;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_515 {

    public List<Integer> largestValues(TreeNode root) {
        final Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.offerLast(root);
        }
        final List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            final int levelSize = queue.size();
            int max = Integer.MIN_VALUE;
            for (int k = 0; k < levelSize; k++) {
                final TreeNode curr = queue.removeFirst();
                max = Math.max(max, curr.val);
                if (curr.left != null) { queue.offerLast(curr.left); }
                if (curr.right != null) { queue.offerLast(curr.right); }
            }
            res.add(max);
        }
        return res;
    }
}
