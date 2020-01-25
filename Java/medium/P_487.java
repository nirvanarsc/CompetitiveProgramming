package medium;

public class P_487 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int k = 1, i = 0;
        for (int num : nums) {
            if (num == 0) { k--; }
            if (k < 0 && nums[i++] == 0) { k++; }
        }
        return nums.length - i;
    }
}
