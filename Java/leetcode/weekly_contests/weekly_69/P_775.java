package leetcode.weekly_contests.weekly_69;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_775 {

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

    public boolean isIdealPermutation(int[] A) {
        int global = 0;
        int local = 0;
        final int n = A.length;
        final BIT bit = new BIT(n);
        for (int i = 0; i < n; i++) {
            if (i < (n - 1) && A[i] > A[i + 1]) {
                local++;
            }
            global += bit.sum(A[i], n);
            bit.add(A[i], 1);
        }
        return global == local;
    }
}
