package leetcode.medium;

public class P_280 {

    public void wiggleSort(int[] nums) {
        boolean dir = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (dir && nums[i] > nums[i + 1] || !dir && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
            dir ^= true;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        final int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }
}
