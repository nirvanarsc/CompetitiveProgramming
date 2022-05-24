package leetcode.weekly_contests.weekly_0_99.weekly_44;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recurse(nums, 0, nums.length - 1);
    }

    private static TreeNode recurse(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int idx = start;
        for (int i = start; i <= end; i++) {
            if (nums[idx] < nums[i]) {
                idx = i;
            }
        }
        final TreeNode root = new TreeNode(nums[idx]);
        root.left = recurse(nums, start, idx - 1);
        root.right = recurse(nums, idx + 1, end);
        return root;
    }
}
