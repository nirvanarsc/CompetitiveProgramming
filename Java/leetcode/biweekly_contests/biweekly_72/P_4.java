package leetcode.biweekly_contests.biweekly_72;

public class P_4 {

    private static final class BIT {
        private final int n;
        private final long[] data;

        private BIT(int n) {
            this.n = n;
            data = new long[n + 1];
        }

        public void add(int idx, long val) {
            for (int i = idx + 1; i <= n; i += lsb(i)) {
                data[i] += val;
            }
        }

        public long sum(int l, int r) {
            return sum(r) - sum(l - 1);
        }

        private long sum(int idx) {
            long res = 0;
            for (int i = idx + 1; i > 0; i -= lsb(i)) {
                res += data[i];
            }
            return res;
        }

        private static int lsb(int i) {
            return i & -i;  // zeroes all the bits except the least significant one
        }

        // get k-th element
        public int getKth(int k) {
            int lo = 0;
            int hi = n;
            while (lo < hi) {
                final int mid = lo + hi >>> 1;
                if (k > sum(mid)) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        final int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            map[nums2[i]] = i;
        }
        final BIT bit = new BIT(n);
        long res = 0;
        for (int i = 0; i < n; i++) {
            final int idx = map[nums1[i]];
            final long L = bit.sum(idx);
            final long R = (n - 1 - idx) - (i - L);
            bit.add(idx, 1);
            res += L * R;
        }
        return res;
    }
}
