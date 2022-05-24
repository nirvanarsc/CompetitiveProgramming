package leetcode.weekly_contests.weekly_100_199.weekly_150;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.TreeNode;

public class P_1161 {

    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        int level = 0;
        final Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        while (!q.isEmpty()) {
            level++;
            int levelSum = 0;
            for (int i = q.size(); i > 0; i--) {
                final TreeNode curr = q.removeFirst();
                levelSum += curr.val;
                if (curr.left != null) {
                    q.offerLast(curr.left);
                }
                if (curr.right != null) {
                    q.offerLast(curr.right);
                }
            }
            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}
