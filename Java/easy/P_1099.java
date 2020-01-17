package easy;

import java.util.Arrays;

public class P_1099 {

    public int twoSumLessThanK(int[] a, int k) {
        Arrays.sort(a);
        int lo = 0;
        int hi = a.length - 1;
        int res = -1;
        while (lo < hi) {
            if (a[lo] + a[hi] >= k) {
                hi--;
            } else {
                res = Math.max(res, a[lo] + a[hi]);
                lo++;
            }
        }
        return res;
    }
}
