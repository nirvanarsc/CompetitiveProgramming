package medium;

public class P_307 {

    static class BIT {
        int[] bit;

        BIT(int n) {
            bit = new int[n + 1];
        }

        void add(int i, int val) {
            while (i < bit.length) {
                bit[i] += val;
                i += i & -i;
            }
        }

        int query(int i) {
            int ans = 0;
            while (i > 0) {
                ans += bit[i];
                i &= i - 1;
            }
            return ans;
        }
    }

    static class NumArray {
        BIT bit;
        int[] nums;

        NumArray(int[] nums) {
            bit = new BIT(nums.length + 1);
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
