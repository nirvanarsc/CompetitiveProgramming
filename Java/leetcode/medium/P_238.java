package leetcode.medium;

public class P_238 {

    public int[] productExceptSelf(int[] nums) {
        final int[] helper = new int[nums.length];
        int prod = helper[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            helper[i] = prod;
            prod *= nums[i];
        }
        prod = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 1; i--) {
            helper[i] *= prod;
            prod *= nums[i];
        }
        helper[0] = prod;

        return helper;
    }
}
