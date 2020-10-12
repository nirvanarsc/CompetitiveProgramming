package leetcode.weekly_contests.weekly_27;

import utils.DataStructures.TreeNode;

public class P_549 {

    public int longestConsecutive(TreeNode root) {
        return dfs(root)[2];
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0, 0 };
        }
        int inr = 1, dcr = 1, ans = 0;
        if (root.left != null) {
            final int[] l = dfs(root.left);
            if (root.val == root.left.val + 1) {
                dcr = l[1] + 1;
            } else if (root.val == root.left.val - 1) {
                inr = l[0] + 1;
            }
            ans = Math.max(ans, l[2]);
        }
        if (root.right != null) {
            final int[] r = dfs(root.right);
            if (root.val == root.right.val + 1) {
                dcr = Math.max(dcr, r[1] + 1);
            } else if (root.val == root.right.val - 1) {
                inr = Math.max(inr, r[0] + 1);
            }
            ans = Math.max(ans, r[2]);
        }
        return new int[] { inr, dcr, Math.max(ans, dcr + inr - 1) };
    }
}
