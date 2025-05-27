package leetcode.biweekly_contests.biweekly_100_199.biweekly_138;

import java.util.PriorityQueue;

public class P_3 {

    public long minDamage(int power, int[] damage, int[] health) {
        // compare a[0] / a[1] and b[0] / b[1], but to avoid division, use multiplication
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0] * b[1], b[0] * a[1]));
        final int n = damage.length;
        long curr = 0;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { (health[i] + power - 1) / power, damage[i] });
            curr += damage[i];
        }
        long res = 0;
        while (!pq.isEmpty()) {
            final int[] pop = pq.remove();
            res += curr * pop[0];
            curr -= pop[1];
        }
        return res;
    }
}
