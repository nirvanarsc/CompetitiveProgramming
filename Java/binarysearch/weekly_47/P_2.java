package binarysearch.weekly_47;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    }

    public int solve(int[] a, int[] b, int lower, int upper) {
        final Set<Integer> uniq = new HashSet<>();
        for (int num : a) {
            uniq.add(upper - num * num);
            uniq.add(lower - num * num);
        }
        for (int num : b) {
            uniq.add(num * num);
        }
        final List<Integer> list = new ArrayList<>(uniq);
        list.sort(Comparator.naturalOrder());
        int idx = 0;
        final Map<Integer, Integer> norm = new HashMap<>();
        for (int num : list) {
            norm.put(num, idx++);
        }
        return f(a, b, lower, upper, norm, idx);
    }

    private static int f(int[] a, int[] b, int lower, int upper, Map<Integer, Integer> map, int n) {
        final BIT bit = new BIT(n);
        for (int num : b) {
            bit.add(map.get(num * num), 1);
        }
        int res = 0;
        for (int num : a) {
            res += bit.sum(map.get(lower - num * num), map.get(upper - num * num));
        }
        return res;
    }
}
