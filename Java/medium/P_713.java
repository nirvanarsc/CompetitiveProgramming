package medium;

public class P_713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int j = 0, prod = 1, res = 0;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            while (prod >= k) {
                prod /= nums[j++];
            }
            res += i - j + 1;
        }
        return res;
    }

    public int numSubarrayProductLessThanKBS(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        final double logk = Math.log(k);
        final double[] prefix = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + Math.log(nums[i]);
        }
        int res = 0;
        for (int i = 0; i < prefix.length; i++) {
            int lo = i, hi = prefix.length - 1;
            while (lo < hi) {
                final int mid = (lo + hi + 1) >>> 1;
                if (prefix[mid] < prefix[i] + logk) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            res += lo - i;
        }
        return res;
    }
}
