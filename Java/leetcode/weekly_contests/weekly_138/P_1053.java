package leetcode.weekly_contests.weekly_138;

public class P_1053 {

    public int[] prevPermOpt1(int[] nums) {
        int index = nums.length - 1;
        while (index > 0 && nums[index - 1] <= nums[index]) {
            index--;
        }
        if (index == 0) {
            return nums;
        }
        final int i = index - 1;
        int pos = index;
        while (index < nums.length) {
            if (nums[index] < nums[i]) {
                if (nums[index] > nums[pos]) {
                    pos = index;
                }
                index++;
            } else {
                break;
            }
        }
        swap(nums, i, pos);
        return nums;
    }

    private static void swap(int[] nums, int left, int right) {
        final int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
