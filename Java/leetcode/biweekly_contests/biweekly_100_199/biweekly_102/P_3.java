package leetcode.biweekly_contests.biweekly_100_199.biweekly_102;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.DataStructures.TreeNode;

public class P_3 {

    public TreeNode replaceValueInTree(TreeNode root) {
        final Deque<TreeNode> dq = new ArrayDeque<>();
        final List<Integer> sums = new ArrayList<>();
        final Map<TreeNode, Integer> neighbourSum = new HashMap<>();
        dq.offerLast(root);
        neighbourSum.put(root, root.val);
        while (!dq.isEmpty()) {
            int level = 0;
            for (int size = dq.size(); size > 0; size--) {
                final TreeNode u = dq.removeFirst();
                level += u.val;
                if (u.left != null) {
                    dq.offerLast(u.left);
                    neighbourSum.put(u.left, u.left.val + (u.right != null ? u.right.val : 0));
                }
                if (u.right != null) {
                    dq.offerLast(u.right);
                    neighbourSum.put(u.right, u.right.val + (u.left != null ? u.left.val : 0));
                }
            }
            sums.add(level);
        }
        dq.offerLast(root);
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final TreeNode u = dq.removeFirst();
                u.val = sums.get(level) - neighbourSum.get(u);
                if (u.left != null) {
                    dq.offerLast(u.left);
                }
                if (u.right != null) {
                    dq.offerLast(u.right);
                }
            }
        }
        return root;
    }
}
