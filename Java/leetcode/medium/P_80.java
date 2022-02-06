package leetcode.medium;

public final class P_80 {

    public int removeDuplicates(int[] nums) {
        final int n = nums.length;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int k = i;
            while (k < n && nums[k] == nums[i]) {
                k++;
            }
            final int count = k - i;
            for (int l = 0; l < Math.min(2, count); l++) {
                nums[idx++] = nums[i];
            }
            i = k - 1;
        }
        return idx;
    }
}
