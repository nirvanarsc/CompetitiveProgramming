package leetcode.biweekly_contests.biweekly_0_99.biweekly_11;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_1231 {

    public int maximizeSweetness(int[] sweetness, int K) {
        int lo = 0;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (!f(sweetness, mid, K + 1)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo + 1;
    }

    private static boolean f(int[] arr, int mid, int k) {
        int cuts = 1;
        int sum = 0;
        for (int num : arr) {
            sum += num;
            if (sum > mid) {
                cuts++;
                sum = 0;
            }
        }
        return cuts <= k;
    }
}
