package leetcode.weekly_contests.weekly_0_99.weekly_94;

public class P_875 {

    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            final int curr = getMid(piles, mid);
            if (curr > h) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int getMid(int[] piles, int mid) {
        int res = 0;
        for (int p : piles) {
            res += (p + mid - 1) / mid;
        }
        return res;
    }
}
