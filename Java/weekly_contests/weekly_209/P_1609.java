package weekly_contests.weekly_209;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_1609 {

    public boolean isEvenOddTree(TreeNode root) {
        final Deque<TreeNode> q = new ArrayDeque<>();
        if (root != null) {
            q.offerLast(root);
        }
        for (int i = 0; !q.isEmpty(); i++) {
            final List<Integer> level = new ArrayList<>();
            for (int size = q.size(); size > 0; size--) {
                final TreeNode curr = q.removeFirst();
                level.add(curr.val);
                if (curr.left != null) { q.offerLast(curr.left); }
                if (curr.right != null) { q.offerLast(curr.right); }
            }
            int prev = -1;
            for (int num : level) {
                if (i % 2 == 0) {
                    if (num % 2 == 0) { return false; }
                    if (prev != -1 && prev >= num) { return false; }
                } else {
                    if (num % 2 != 0) { return false; }
                    if (prev != -1 && prev <= num) { return false; }
                }
                prev = num;
            }
        }
        return true;
    }
}
