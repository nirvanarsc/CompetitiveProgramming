package leetcode.weekly_contests.weekly_300_399.weekly_338;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P_3 {

    public List<Long> minOperations(int[] nums, int[] queries) {
        final int n = nums.length;
        final int q = queries.length;
        final int[][] sorted = new int[q][2];
        for (int i = 0; i < q; i++) {
            sorted[i] = new int[] { queries[i], i };
        }
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(nums);
        final long[] sum = new long[2];
        final long[] size = new long[2];
        for (int num : nums) {
            sum[1] += num;
            size[1] += 1;
        }
        int j = 0;
        final List<Long> res = new ArrayList<>(Collections.nCopies(q, 0L));
        for (int i = 0; i < q; i++) {
            while (j < n && sorted[i][0] > nums[j]) {
                size[0]++;
                size[1]--;
                sum[0] += nums[j];
                sum[1] -= nums[j];
                j++;
            }
            final long curr = (sum[1] - (size[1] * sorted[i][0])) + ((size[0] * sorted[i][0]) - sum[0]);
            res.set(sorted[i][1], curr);
        }
        return res;
    }
}
