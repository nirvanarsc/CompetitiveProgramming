package leetcode.medium;

public class P_238 {

    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        final int[] res = new int[n];
        int curr = res[0] = nums[0];
        for (int i = 1; i < n; i++) {
            res[i] = curr;
            curr *= nums[i];
        }
        curr = nums[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            res[i] *= curr;
            curr *= nums[i];
        }
        res[0] = curr;
        return res;
    }
}
