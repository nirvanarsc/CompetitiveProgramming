package weekly_contests.weekly_69;

public class P_774 {

    private static final double EPSILON = 1e-5;

    @SuppressWarnings("MethodParameterNamingConvention")
    public double minmaxGasDist(int[] stations, int K) {
        double lo = 0;
        double hi = 1e8;
        while (hi - lo > EPSILON) {
            final double mid = 0.5 * (lo + hi);
            if (f(stations, mid) > K) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int f(int[] stations, double limit) {
        int res = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            final int dist = stations[i + 1] - stations[i];
            res += Math.ceil(dist / limit) - 1;
        }
        return res;
    }
}
