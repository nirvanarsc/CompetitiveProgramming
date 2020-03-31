package weekly_contests.weekly_74;

public class P_793 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int preimageSizeFZF(int K) {
        long lo = 0;
        long hi = (long) 1e18;
        while (lo < hi) {
            final long mid = lo + hi >>> 1;
            if (trailingZeroes(mid) < K) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return trailingZeroes(lo) == K ? 5 : 0;
    }

    public static long trailingZeroes(long n) {
        long res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
