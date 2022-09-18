package leetcode.weekly_contests.weekly_300_399.weekly_311;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

import utils.DataStructures.TreeNode;

public class P_3 {

    public TreeNode reverseOddLevels(TreeNode root) {
        final Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offerLast(root);
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final TreeNode u = dq.removeFirst();
                if (u.left != null) {
                    dq.offerLast(u.left);
                }
                if (u.right != null) {
                    dq.offerLast(u.right);
                }
            }
            if (level % 2 == 0) {
                final List<Integer> val = dq.stream().map(node -> node.val).collect(Collectors.toList());
                for (int size = dq.size(); size > 0; size--) {
                    final TreeNode u = dq.removeFirst();
                    u.val = val.get(size - 1);
                    dq.offerLast(u);
                }
            }
        }
        return root;
    }
}
