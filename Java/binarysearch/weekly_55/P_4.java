package binarysearch.weekly_55;

import java.util.Arrays;

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
            return sum(r - 1) - sum(l - 1);
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
    }

    public int[] solve(int[] tickets) {
        final int n = tickets.length;
        final BIT bitSum = new BIT(n);
        final BIT bitCount = new BIT(n);
        final int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i] = new int[] { tickets[i], i };
        }
        Arrays.sort(nums, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1])
                                                 : Integer.compare(a[0], b[0]));
        final int[] res = new int[n];
        long count = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            final int t = nums[i][0];
            final int idx = nums[i][1];

            final long cntL = bitCount.sum(idx);
            final long cntR = count - cntL;
            final long sumL = bitSum.sum(idx);
            final long sumR = sum - sumL;

            final int base = (t - 1) * n + idx + 1;
            final long reduceL = t * cntL - sumL;
            final long reduceR = (t - 1) * cntR - sumR;
            res[idx] = (int) (base - reduceL - reduceR);

            bitSum.add(idx, t);
            bitCount.add(idx, 1);
            count++;
            sum += t;
        }
        return res;
    }
}
