package leetcode.weekly_contests.weekly_200_299.weekly_288;

import java.util.PriorityQueue;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    public int maximumProduct(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }
        for (int i = 0; i < k; i++) {
            pq.add(pq.remove() + 1);
        }
        long res = 1;
        while (!pq.isEmpty()) {
            res = (res * pq.remove()) % MOD;
        }
        return (int) res;
    }
}
