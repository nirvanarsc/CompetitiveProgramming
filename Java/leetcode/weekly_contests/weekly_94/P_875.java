package leetcode.weekly_contests.weekly_94;

public class P_875 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int minEatingSpeed(int[] piles, int H) {
        int max = Integer.MIN_VALUE;
        for (int p : piles) {
            max = Math.max(p, max);
        }

        int lo = 1, hi = max;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            final int curr = getMid(piles, mid);
            if (curr > H) {
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
            res += p / mid;
            res += p % mid == 0 ? 0 : 1;
        }
        return res;
    }
}
