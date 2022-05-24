package leetcode.weekly_contests.weekly_200_299.weekly_202;

import java.util.Arrays;

public class P_1552 {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 0, hi = (int) 1e9;
        while (lo < hi) {
            final int mid = (lo + hi + 1) >>> 1;
            if (f(position, mid, m)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private static boolean f(int[] position, int mid, int m) {
        int curr = position[0];
        int matched = 1;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - curr >= mid) {
                curr = position[i];
                matched++;
            }
        }
        return matched >= m;
    }
}
