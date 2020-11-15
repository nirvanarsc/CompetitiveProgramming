package leetcode.biweekly_contests.biweekly_39;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class P_1654 {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(val -> val[1]));
        pq.offer(new int[] { 0, 0, 0 });
        final Set<Integer> banned = new HashSet<>();
        for (int num : forbidden) {
            banned.add(num);
        }
        final boolean[][] seen = new boolean[4005][2];
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int idx = curr[0];
            final int cost = curr[1];
            final int jump = curr[2];
            if (idx == x) {
                return cost;
            }
            if (seen[idx][jump]) {
                continue;
            }
            seen[idx][jump] = true;
            final int forward = idx + a;
            final int backward = idx - b;
            if (forward < seen.length && !banned.contains(forward)) {
                pq.offer(new int[] { forward, cost + 1, 0 });
            }
            if (jump == 0 && backward >= 0 && !banned.contains(backward)) {
                pq.offer(new int[] { backward, cost + 1, 1 });
            }
        }
        return -1;
    }
}
