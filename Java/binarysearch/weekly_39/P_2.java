package binarysearch.weekly_39;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_2 {

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

    public int solve(int[] nums, int[][] queries) {
        if (nums.length < 2) {
            return queries.length;
        }
        final int n = nums.length;
        final int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = nums[i + 1] - nums[i];
        }
        final int[] rightSize = new int[n];
        final int[][][] buckets = new int[n][][];
        final int[] bucketIndex = new int[n];
        final Map<Integer, Integer> normalized = new HashMap<>();
        int nIdx = 0;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (!normalized.containsKey(diff[i])) {
                normalized.put(diff[i], nIdx++);
            }
        }
        for (int[] qq : queries) {
            if (qq[1] - qq[0] < 2) {
                res++;
                continue;
            }
            rightSize[qq[1] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            buckets[i] = new int[rightSize[i]][2];
        }
        for (int[] qq : queries) {
            if (qq[1] - qq[0] < 2) {
                continue;
            }
            buckets[qq[1] - 1][bucketIndex[qq[1] - 1]++] = qq;
        }
        final BIT bit = new BIT(n);
        final int[] last = new int[n];
        Arrays.fill(last, -1);
        for (int i = 0; i < n - 1; i++) {
            final int idx = normalized.get(diff[i]);
            if (last[idx] != -1) {
                bit.add(last[idx], -1);
            }
            last[idx] = i;
            bit.add(i, 1);
            for (int[] query : buckets[i]) {
                if (bit.sum(query[0], query[1] - 1) == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
