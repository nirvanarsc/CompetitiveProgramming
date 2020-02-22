package biweekly_4;

public class P_1121 {

    public boolean canDivideIntoSubsequences(int[] nums, int k) {
        int curr = 1, total = 1;
        for (int i = 1; i < nums.length; i++) {
            curr = nums[i - 1] == nums[i] ? curr + 1 : 1;
            total = Math.max(curr, total);
        }
        return k * total <= nums.length;
    }
}
