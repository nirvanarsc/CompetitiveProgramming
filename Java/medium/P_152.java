package medium;

public class P_152 {

    public int maxProduct(int[] nums) {
        int res = nums[0];
        for (int i = 1, currMax = res, currMin = res; i < nums.length; i++) {
            if (nums[i] < 0) {
                final int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(nums[i], currMax * nums[i]);
            currMin = Math.min(nums[i], currMin * nums[i]);
            res = Math.max(res, currMax);
        }
        return res;
    }

    public int maxProduct2(int[] nums) {
        int res = Integer.MIN_VALUE, l = 0, r = 0;
        for (int i = 0; i < nums.length; i++) {
            l = (l == 0 ? 1 : l) * nums[i];
            r = (r == 0 ? 1 : r) * nums[nums.length - 1 - i];
            res = Math.max(res, Math.max(l, r));
        }
        return res;
    }
}
