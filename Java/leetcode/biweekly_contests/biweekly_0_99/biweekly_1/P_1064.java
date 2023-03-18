package leetcode.biweekly_contests.biweekly_0_99.biweekly_1;

public class P_1064 {

    public int fixedPoint(int[] A) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (A[mid] >= mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return A[lo] == lo ? lo : -1;
    }
}
