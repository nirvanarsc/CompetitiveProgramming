package leetcode.weekly_contests.weekly_300_399.weekly_307;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P_4 {

    public long kSum(int[] nums, int k) {
        long s = 0;
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            s += Math.max(0, nums[i]);
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        final PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        pq.offer(new long[] { s, -1 });
        for (int i = 0; i < k - 1; i++) {
            final long[] u = pq.remove();
            final int v = (int) u[1];
            if (v + 1 < n) {
                if (v > -1) {
                    pq.offer(new long[] { u[0] + nums[v] - nums[v + 1], v + 1 });
                }
                pq.offer(new long[] { u[0] - nums[v + 1], v + 1 });
            }
        }
        return pq.element()[0];
    }
}
