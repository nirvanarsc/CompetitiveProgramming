package leetcode.hard;

import java.util.Arrays;

import utils.DataStructures.BIT;

public class P_327 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int index = 0, count = 0;
        final long[] sum = new long[nums.length + 1];
        final long[] cand = new long[3 * sum.length];
        final BIT bit = new BIT(cand.length);

        for (int i = 0; i < sum.length; i++) {
            sum[i] = i == 0 ? 0 : sum[i - 1] + nums[i - 1];
            cand[index++] = sum[i];
            cand[index++] = lower + sum[i] - 1;
            cand[index++] = upper + sum[i];
        }
        Arrays.sort(cand);

        for (long value : sum) {
            bit.add(Arrays.binarySearch(cand, value) + 1, 1);
        }

        for (long value : sum) {
            bit.add(Arrays.binarySearch(cand, value) + 1, -1);
            count += bit.query(Arrays.binarySearch(cand, upper + value) + 1);
            count -= bit.query(Arrays.binarySearch(cand, lower + value - 1) + 1);
        }

        return count;
    }
}
