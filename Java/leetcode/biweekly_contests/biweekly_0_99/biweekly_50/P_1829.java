package leetcode.biweekly_contests.biweekly_0_99.biweekly_50;

public class P_1829 {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        final int n = nums.length;
        final int[] res = new int[n];
        final int max = (1 << maximumBit) - 1;
        for (int i = 0; i < n; i++) {
            res[i] = max ^ xor;
            xor ^= nums[n - 1 - i];
        }
        return res;
    }
}
