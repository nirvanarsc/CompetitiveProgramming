package binarysearch.weekly_41;

public class P_1 {

    public boolean solve(int[] nums) {
        final int n = nums.length;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int j = i;
                while (j < n && nums[j] == nums[i]) {
                    j++;
                }
                return count == j - i;
            }
        }
        return false;
    }
}
