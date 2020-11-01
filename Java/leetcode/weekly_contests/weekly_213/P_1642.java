package leetcode.weekly_contests.weekly_213;

import java.util.PriorityQueue;

public class P_1642 {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        final PriorityQueue<Integer> jumps = new PriorityQueue<>();
        final int n = heights.length;
        for (int i = 0; i < n - 1; i++) {
            if (heights[i] < heights[i + 1]) {
                jumps.add(heights[i + 1] - heights[i]);
            }
            if (jumps.size() > ladders) {
                final int min = jumps.remove();
                if (min > bricks) {
                    return i;
                } else {
                    bricks -= min;
                }
            }
        }
        return n - 1;
    }
}
