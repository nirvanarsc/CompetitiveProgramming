package leetcode.weekly_contests.weekly_100_199.weekly_163;

import java.util.HashSet;
import java.util.Set;

import utils.DataStructures.TreeNode;

public class P_1261 {

    static class FindElements {
        Set<Integer> seen = new HashSet<>();

        FindElements(TreeNode root) {
            initialize(root, 0);
        }

        public boolean find(int target) {
            return seen.contains(target);
        }

        public void initialize(TreeNode root, int val) {
            if (root == null) {
                return;
            }
            seen.add(val);
            root.val = val;
            initialize(root.left, 2 * val + 1);
            initialize(root.right, 2 * val + 2);
        }
    }
}
