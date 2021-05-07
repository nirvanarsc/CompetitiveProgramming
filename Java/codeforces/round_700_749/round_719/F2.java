package codeforces.round_700_749.round_719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class F2 {

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

    static FastScanner fs;

    public static void main(String[] args) {
        fs = new FastScanner();
        final int n = fs.nextInt();
        final int t = fs.nextInt();
        final int seg = (n + 31) / 32;
        final BIT bit = new BIT(seg);
        final int q = fs.nextInt();
        int l = 1;
        for (int i = 0; i < seg; i++) {
            final int r = Math.min(n, l + 31);
            bit.add(i, 32 - query(l, r));
            l += 32;
        }
        System.out.printf("! %d\n", answer(q, n, bit));
        for (int i = 1; i < t; i++) {
            System.out.printf("! %d\n", answer(fs.nextInt(), n, bit));
        }
    }

    private static int query(int l, int r) {
        System.out.printf("? %d %d\n", l, r);
        return fs.nextInt();
    }

    private static int answer(int k, int n, BIT bit) {
        final int seg = bit.getKth(k);
        int lo = seg * 32 + 1;
        int hi = Math.min(n, (seg + 1) * 32 - 1) + 1;
        long target = k - (seg > 0 ? bit.sum(seg - 1) : 0);
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            final int qry = query(lo, mid);
            final int zero = (mid - lo + 1) - qry;
            if (zero < target) {
                lo = mid + 1;
                target -= zero;
            } else {
                hi = mid;
            }
        }
        bit.add(seg, -1);
        return lo;
    }

    static final class Utils {
        private static class Shuffler {
            private static void shuffle(int[] x) {
                final Random r = new Random();

                for (int i = 0; i <= x.length - 2; i++) {
                    final int j = i + r.nextInt(x.length - i);
                    swap(x, i, j);
                }
            }

            private static void shuffle(long[] x) {
                final Random r = new Random();

                for (int i = 0; i <= x.length - 2; i++) {
                    final int j = i + r.nextInt(x.length - i);
                    swap(x, i, j);
                }
            }

            private static void swap(int[] x, int i, int j) {
                final int t = x[i];
                x[i] = x[j];
                x[j] = t;
            }

            private static void swap(long[] x, int i, int j) {
                final long t = x[i];
                x[i] = x[j];
                x[j] = t;
            }
        }

        public static void shuffleSort(int[] arr) {
            Shuffler.shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffleSort(long[] arr) {
            Shuffler.shuffle(arr);
            Arrays.sort(arr);
        }

        private Utils() {}
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        private String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    //noinspection CallToPrintStackTrace
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int[] nextIntArray(int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) { a[i] = nextInt(); }
            return a;
        }

        long[] nextLongArray(int n) {
            final long[] a = new long[n];
            for (int i = 0; i < n; i++) { a[i] = nextLong(); }
            return a;
        }
    }
}
