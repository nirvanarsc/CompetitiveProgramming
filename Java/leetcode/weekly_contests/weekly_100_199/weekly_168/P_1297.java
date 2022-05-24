package leetcode.weekly_contests.weekly_100_199.weekly_168;

import java.util.Deque;
import java.util.LinkedList;

public class P_1297 {

    public int maxCandies(int[] status,
                          int[] candies,
                          int[][] keys,
                          int[][] containedBoxes,
                          int[] initialBoxes) {
        final int n = status.length;
        final boolean[] got = new boolean[n];
        final boolean[] done = new boolean[n];
        final Deque<Integer> queue = new LinkedList<>();
        for (int v : initialBoxes) {
            queue.offerLast(v);
            got[v] = true;
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            final int curr = queue.removeFirst();
            if (status[curr] == 1 && !done[curr]) {
                done[curr] = true;
                ans += candies[curr];
                for (int k : keys[curr]) {
                    status[k] = 1;
                    if (got[k]) {
                        queue.offerLast(k);
                    }
                }
                for (int k : containedBoxes[curr]) {
                    got[k] = true;
                    queue.offerLast(k);
                }
            }
        }
        return ans;
    }
}
