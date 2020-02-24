package weekly_contests.weekly_155;

public class P_1201 {

    private static long gcd(long a, long b) {
        while (true) {
            if (a == 0) {
                return b;
            }

            final long t = a;
            a = b % t;
            b = t;
        }
    }

    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    private static int count(long a, long b, long c, long num) {
        return (int) ((num / a) + (num / b) + (num / c)
                      - (num / lcm(a, b))
                      - (num / lcm(b, c))
                      - (num / lcm(a, c))
                      + (num / lcm(a, lcm(b, c))));
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        int low = 1, high = Integer.MAX_VALUE;

        while (low < high) {
            final int mid = low + high >>> 1;

            if (count(a, b, c, mid) < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
