package leetcode.medium;

public class P_55 {

    public boolean canJump(int[] nums) {
        final int n = nums.length;
        int curr = nums[0];
        for (int i = 0; i < n; i++) {
            if (i > curr) {
                return false;
            }
            curr = Math.max(curr, i + nums[i]);
        }
        return true;
    }
}
