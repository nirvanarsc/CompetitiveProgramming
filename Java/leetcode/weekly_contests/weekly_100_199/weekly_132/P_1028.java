package leetcode.weekly_contests.weekly_100_199.weekly_132;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.TreeNode;

public class P_1028 {

    public TreeNode recoverFromPreorder(String traversal) {
        int i = 0;
        final Deque<TreeNode> dq = new ArrayDeque<>();
        final int n = traversal.length();
        final char[] w = traversal.toCharArray();
        while (i < n) {
            int level;
            int val;
            for (level = 0; w[i] == '-'; i++) {
                level++;
            }
            for (val = 0; i < n && w[i] != '-'; i++) {
                val = val * 10 + (w[i] - '0');
            }
            while (dq.size() > level) {
                dq.removeFirst();
            }
            final TreeNode node = new TreeNode(val);
            if (!dq.isEmpty()) {
                if (dq.getFirst().left == null) {
                    dq.getFirst().left = node;
                } else {
                    dq.getFirst().right = node;
                }
            }
            dq.addFirst(node);
        }
        return dq.removeLast();
    }
}
