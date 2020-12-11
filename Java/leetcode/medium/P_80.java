package leetcode.medium;

public final class P_80 {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            int k = i;
            while (k < nums.length && nums[k] == nums[i]) {
                k++;
            }
            final int count = k - i;
            for (int l = 0; l < Math.min(2, count); l++) {
                nums[j++] = nums[i];
            }
            i = k;
        }
        return j;
    }
}
