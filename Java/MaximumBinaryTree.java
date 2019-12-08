import utils.DataStructures.TreeNode;

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recurse(nums, 0, nums.length - 1);
    }

    public TreeNode recurse(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int maxIdx = 0;
        int max = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        final TreeNode root = new TreeNode(max);
        root.left = recurse(nums, start, maxIdx - 1);
        root.right = recurse(nums, maxIdx + 1, end);
        return root;
    }
}
