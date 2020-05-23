package weekly_contests.smarking_1;

public class P_440 {

    public int findKthNumber(int n, int k) {
        long curr = 1;
        while (k > 1) {
            final long p = prefixCount(curr, curr + 1, n);
            if (k > p) {
                k -= p;
                curr++;
            } else {
                --k;
                curr *= 10;
            }
        }
        return (int) curr;
    }

    private static long prefixCount(long left, long right, int n) {
        long gap = 0;
        while (left <= n) {
            gap += Math.min(n + 1, right) - left;
            left *= 10;
            right *= 10;
        }
        return gap;
    }
}
