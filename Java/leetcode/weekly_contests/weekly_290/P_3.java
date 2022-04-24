package leetcode.weekly_contests.weekly_290;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

@SuppressWarnings("ConstantConditions")
public class P_3 {

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

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        final int n = rectangles.length;
        final int m = points.length;
        final TreeSet<int[]> ts = new TreeSet<>((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1])
                                                                       : Integer.compare(a[0], b[0]));
        final int[] sortedY = new int[n];
        for (int i = 0; i < n; i++) {
            sortedY[i] = rectangles[i][1];
            ts.add(rectangles[i]);
        }
        Arrays.sort(sortedY);
        int idx = 1;
        final Map<Integer, Integer> map = new HashMap<>();
        for (int num : sortedY) {
            if (!map.containsKey(num)) {
                map.put(num, idx++);
            }
        }
        map.put(sortedY[n - 1] + 1, idx++);
        final BIT bit = new BIT(idx);
        for (int num : sortedY) {
            bit.add(map.get(num), 1);
        }
        final int[] res = new int[m];
        final int[][] indexed = new int[m][3];
        for (int i = 0; i < m; i++) {
            indexed[i] = new int[] { points[i][0], points[i][1], i };
        }
        Arrays.sort(indexed, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1])
                                                    : Integer.compare(a[0], b[0]));
        int q = n;
        for (int i = 0; i < m; i++) {
            final int x = indexed[i][0];
            final int y = indexed[i][1];
            while (!ts.isEmpty() && ts.first()[0] < x) {
                final int[] pop = ts.pollFirst();
                bit.add(map.get(pop[1]), -1);
                q--;
            }
            res[indexed[i][2]] = q - (int) bit.sum(map.get(lowerBound(sortedY, y)) - 1);
        }
        return res;
    }

    private static int lowerBound(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo == arr.length ? arr[lo - 1] + 1 : arr[lo];
    }
}
