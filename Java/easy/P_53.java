package easy;

public class P_53 {

    public int maxSubArray(int[] nums) {
        int curr = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            curr = Math.max(nums[i], curr + nums[i]);
            res = Math.max(res, curr);
        }

        return res;
    }
}
