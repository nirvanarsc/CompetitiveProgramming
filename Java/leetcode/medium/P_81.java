package leetcode.medium;

public final class P_81 {

    public boolean search(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
