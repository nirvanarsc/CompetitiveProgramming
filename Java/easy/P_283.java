package easy;

public class P_283 {

    public void moveZeroes(int[] nums) {
        int swapIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                final int temp = nums[i];
                nums[i] = nums[swapIdx];
                nums[swapIdx] = temp;
                swapIdx++;
            }
        }
    }
}
