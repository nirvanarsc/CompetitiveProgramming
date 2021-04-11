package leetcode.weekly_contests.weekly_236;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused" })
public class P_1825 {

    class MKAverage {
        private final class BIT {
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

            private int lsb(int i) {
                return i & -i;  // zeroes all the bits except the least significant one
            }
        }

        BIT index;
        BIT value;
        Deque<Integer> data;
        int m;
        int k;

        MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
            index = new BIT((int) (1e5 + 5));
            value = new BIT((int) (1e5 + 5));
            data = new ArrayDeque<>();
        }

        public void addElement(int num) {
            data.addFirst(num);
            value.add(num, num);
            index.add(num, 1);
            if (data.size() > m) {
                final int last = data.removeLast();
                value.add(last, -last);
                index.add(last, -1);
            }
        }

        private int getIdx(int k) {
            int lo = 0;
            int hi = (int) (1e5 + 5);
            while (lo < hi) {
                final int mid = lo + hi >>> 1;
                if (index.sum(mid) < k) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }

        public int calculateMKAverage() {
            if (data.size() < m) {
                return -1;
            }
            final int lo = getIdx(k);
            final int hi = getIdx(m - k);
            long res = value.sum(hi) - value.sum(lo);
            res += (index.sum(lo) - k) * lo;
            res -= (index.sum(hi) - (m - k)) * hi;
            return (int) (res / (m - 2 * k));
        }
    }
}
