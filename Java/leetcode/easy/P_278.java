package leetcode.easy;

import java.util.Random;

public class P_278 {

    boolean isBadVersion(int n) {
        return new Random().nextInt(1) == 0;
    }

    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;

        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
