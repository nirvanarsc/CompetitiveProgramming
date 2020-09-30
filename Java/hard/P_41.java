package hard;

public class P_41 {

    public int firstMissingPositive(int[] nums) {
        final int n = nums.length;
        final int outOfRange = n + 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = outOfRange;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num >= outOfRange) {
                continue;
            }
            num--;
            if (nums[num] > 0) {
                nums[num] = -nums[num];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return outOfRange;
    }
}
