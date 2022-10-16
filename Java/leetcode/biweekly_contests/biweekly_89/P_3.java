package leetcode.biweekly_contests.biweekly_89;

public class P_3 {

    public int minimizeArrayValue(int[] nums) {
        int lo = 0;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (!f(mid, nums)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static boolean f(int mid, int[] arr) {
        long spare = 0;
        for (int num : arr) {
            if (num < mid) {
                spare += mid - num;
            } else {
                spare -= num - mid;
            }
            if (spare < 0) {
                return false;
            }
        }
        return true;
    }
}
