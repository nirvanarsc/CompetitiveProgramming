package medium;

import utils.DataStructures.BIT;

public class P_307 {

    static class NumArray {
        BIT bit;
        int[] nums;

        NumArray(int[] nums) {
            bit = new BIT(nums.length);
            for (int i = 0; i < nums.length; i++) {
                bit.add(i + 1, nums[i]);
            }
            this.nums = nums;
        }

        public void update(int i, int val) {
            bit.add(i + 1, val - nums[i]);
            nums[i] = val;
        }

        public int sumRange(int i, int j) {
            return bit.query(j + 1) - bit.query(i);
        }
    }
}
