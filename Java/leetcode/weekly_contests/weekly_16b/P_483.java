package leetcode.weekly_contests.weekly_16b;

public class P_483 {

    public String smallestGoodBase(String n) {
        final long num = Long.valueOf(n);

        for (int m = (int) (Math.log(num + 1) / Math.log(2)); m > 2; m--) {
            long l = (long) Math.pow(num + 1, 1.0 / m);
            long r = (long) Math.pow(num, 1.0 / (m - 1));

            while (l <= r) {
                final long mid = l + r >>> 1;
                long f = 0L;
                for (int i = 0; i < m; i++) {
                    f = f * mid + 1;
                }
                if (num == f) {
                    return String.valueOf(mid);
                } else if (num < f) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return String.valueOf(num - 1);
    }
}
