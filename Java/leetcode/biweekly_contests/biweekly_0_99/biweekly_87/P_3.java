package leetcode.biweekly_contests.biweekly_0_99.biweekly_87;

public class P_3 {

    public int[] smallestSubarrays(int[] nums) {
        final int n = nums.length;
        final int[] bitIdx = new int[31];
        final int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 31; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    bitIdx[j] = i;
                }
            }
            int idx = i;
            for (int j = 0; j < 31; j++) {
                idx = Math.max(idx, bitIdx[j]);
            }
            res[i] = idx - i + 1;
        }
        return res;
    }
}
