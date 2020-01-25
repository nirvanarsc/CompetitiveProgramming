package medium;

public class P_1004 {

    public int longestOnesSimple(int[] nums, int k) {
        int i = 0;
        for (int value : nums) {
            if (value == 0) { k--; }
            if (k < 0 && nums[i++] == 0) { k++; }
        }
        return nums.length - i;
    }
}
