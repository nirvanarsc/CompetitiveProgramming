package leetcode.medium;

public class P_152 {

    public int maxProduct(int[] nums) {
        int prevMin = nums[0];
        int prevMax = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            final int currMin = Math.min(nums[i], Math.min(nums[i] * prevMin, nums[i] * prevMax));
            final int currMax = Math.max(nums[i], Math.max(nums[i] * prevMax, nums[i] * prevMin));
            res = Math.max(res, currMax);
            prevMin = currMin;
            prevMax = currMax;
        }
        return res;
    }
}
