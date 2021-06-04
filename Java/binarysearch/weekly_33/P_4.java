package binarysearch.weekly_33;

import java.util.Arrays;
import java.util.Comparator;

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

    public int[] solve(int[] nums) {
        final int n = nums.length;
        final int[][] indexed = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexed[i] = new int[] { nums[i], i };
        }
        final BIT bit = new BIT(n);
        for (int i = 0; i < n; i++) {
            bit.add(i, 1);
        }
        Arrays.sort(indexed, Comparator.comparingInt(val -> val[0]));
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            final int u = indexed[i][1];
            res[i] = (int) (bit.sum(u) - 1);
            bit.add(u, -1);
        }
        return res;
    }
}
