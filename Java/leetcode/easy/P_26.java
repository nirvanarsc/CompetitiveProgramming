package leetcode.easy;

public class P_26 {

    public int removeDuplicates(int[] nums) {
        final int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            while (i + 1 < n && nums[i] == nums[i + 1]) {
                i++;
            }
            nums[res++] = nums[i];
        }
        return res;
    }
}
