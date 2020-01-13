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

    public int maxSubArrayRecursive(int[] nums) {
        return recurse(nums, 0, new int[] { Integer.MIN_VALUE, 0 })[0];
    }

    public int[] recurse(int[] nums, int pos, int[] pair) {
        if (pos == nums.length - 1) {
            pair[1] = nums[pos];
            pair[0] = Math.max(pair[0], pair[1]);
            return pair;
        }
        pair[1] = Math.max(nums[pos], nums[pos] + recurse(nums, pos + 1, pair)[1]);
        pair[0] = Math.max(pair[0], pair[1]);
        return pair;
    }
}
