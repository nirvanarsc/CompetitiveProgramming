package medium;

public class P_713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, prod = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i++];
            }
            res += j - i + 1;
        }
        return res;
    }
}
