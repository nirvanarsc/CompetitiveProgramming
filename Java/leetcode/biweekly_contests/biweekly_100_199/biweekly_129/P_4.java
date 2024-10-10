package leetcode.biweekly_contests.biweekly_100_199.biweekly_129;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_4 {

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long res = 0;
        for (int num : nums) {
            res += num;
            pq.offer((k ^ num) - num);
        }
        long curr = res;
        while (pq.size() > 1) {
            for (int i = 0; i < 2; i++) {
                curr += pq.remove();
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
