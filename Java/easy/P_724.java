package easy;

public class P_724 {

    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int left = 0;
        int right = sum - nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (left == right) {
                return i;
            }
            left += nums[i];
            right -= i == nums.length - 1 ? 0 : nums[i + 1];
        }
        return -1;
    }
}
