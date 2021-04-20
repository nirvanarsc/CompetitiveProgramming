package binarysearch.weekly_54;

public class P_1 {

    public boolean solve(int[] nums) {
        if (nums[0] >= nums[1]) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return false;
            }
            int j = i;
            while (j < (nums.length - 1) && Integer.compare(nums[j], nums[j + 1])
                                            == Integer.compare(nums[i], nums[i + 1])) {
                j++;
            }
            i = j - 1;
        }
        return true;
    }
}
