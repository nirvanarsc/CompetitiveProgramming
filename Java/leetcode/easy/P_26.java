package leetcode.easy;

public class P_26 {

    public int removeDuplicates(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
            nums[res++] = nums[i];
        }
        return res;
    }

    public int removeDuplicatesOld(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }
}
