package leetcode.weekly_contests.weekly_200_299.weekly_213;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P_1642 {

    public int furthestBuildingPQ(int[] heights, int bricks, int ladders) {
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

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int lo = 0;
        int hi = heights.length - 1;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (!f(heights, bricks, ladders, mid)) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    private static boolean f(int[] heights, int bricks, int ladders, int mid) {
        int n = 0;
        for (int i = 0; i < mid; i++) {
            if (heights[i + 1] > heights[i]) {
                n++;
            }
        }
        final int[] diff = new int[n];
        int idx = 0;
        for (int i = 0; i < mid; i++) {
            if (heights[i + 1] > heights[i]) {
                diff[idx++] = heights[i + 1] - heights[i];
            }
        }
        Arrays.sort(diff);
        long need = 0;
        for (int i = 0; i < n - ladders; i++) {
            need += diff[i];
        }
        return need <= bricks;
    }
}
