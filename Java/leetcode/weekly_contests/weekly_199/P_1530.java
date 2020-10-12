package leetcode.weekly_contests.weekly_199;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ZeroLengthArrayAllocation", "ConstantConditions" })
public class P_1530 {

    int res;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }

    public int[] dfs(TreeNode root, int distance) {
        if (root == null) {
            return new int[] {};
        }
        if (root.left == null && root.right == null) {
            return new int[] { 1 };
        }
        final int[] left = dfs(root.left, distance);
        final int[] right = dfs(root.right, distance);
        for (int l : left) {
            for (int r : right) {
                if (l + r <= distance) {
                    res++;
                }
            }
        }
        int idx = 0;
        final int[] cur = new int[left.length + right.length];
        for (int l : left) {
            cur[idx++] = l + 1;
        }
        for (int r : right) {
            cur[idx++] = r + 1;
        }
        return cur;
    }
}
