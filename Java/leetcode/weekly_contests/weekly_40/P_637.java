package leetcode.weekly_contests.weekly_40;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_637 {

    public List<Double> averageOfLevels(TreeNode root) {
        final Deque<TreeNode> q = new ArrayDeque<>(Collections.singleton(root));
        final List<Double> res = new ArrayList<>();
        while (!q.isEmpty()) {
            double sum = 0;
            final int level = q.size();
            for (int i = 0; i < level; i++) {
                final TreeNode curr = q.removeFirst();
                sum += curr.val;
                if (curr.left != null) { q.offerLast(curr.left); }
                if (curr.right != null) { q.offerLast(curr.right); }
            }
            res.add(sum / level);
        }
        return res;
    }
}
