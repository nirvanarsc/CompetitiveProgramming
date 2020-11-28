package codeforces.round_650_699.round_668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static class BIT {
        private final int[] bit;

        public BIT(int n) {
            bit = new int[n + 1];
        }

        public void add(int i, int val) {
            i++;
            while (i < bit.length) {
                bit[i] += val;
                i += lsb(i);
            }
        }

        private void rangeUpdate(int l, int r, int val) {
            add(l, val);
            add(r + 1, -val);
        }

        public int query(int i) {
            i++;
            int ans = 0;
            while (i > 0) {
                ans += bit[i];
                i -= lsb(i);
            }
            return ans;
        }

        private static int lsb(int i) {
            return i & -i;  // zeroes all the bits except the least significant one
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int nQ = fs.nextInt();
        final int[] a = fs.nextIntArray(n);
        for (int i = 0; i < n; i++) {
            a[i]--;
        }
        final int[][] queries = new int[nQ][3];
        final int[][] unsorted = new int[nQ][3];
        for (int qq = 0; qq < nQ; qq++) {
            unsorted[qq] = queries[qq] = new int[] { fs.nextInt(), n - 1 - fs.nextInt(), 0 };
        }
        Arrays.sort(queries, Comparator.comparingInt(v -> v[1]));
        final BIT bit = new BIT(n);
        int queryIndex = 0;
        for (int r = 0; r < n; r++) {
            if (a[r] <= r && r - bit.query(0) <= a[r]) {
                int lo = 0, hi = r;
                while (lo < hi) {
                    final int mid = lo + hi + 1 >>> 1;
                    if (a[r] <= r && r - bit.query(mid) <= a[r]) {
                        lo = mid;
                    } else {
                        hi = mid - 1;
                    }
                }
                bit.rangeUpdate(0, lo, 1);
            }
            while (queryIndex < nQ && queries[queryIndex][1] == r) {
                final int[] query = queries[queryIndex++];
                query[2] = bit.query(query[0]);
            }
        }
        final PrintWriter pw = new PrintWriter(System.out);
        for (int[] qq : unsorted) {
            pw.println(qq[2]);
        }
        pw.flush();
    }

    static final class Util {
        public static void shuffleSort(int[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffleSort(long[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffle(int[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void shuffle(long[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void swap(int[] x, int i, int j) {
            final int t = x[i];
            x[i] = x[j];
            x[j] = t;
        }

        public static void swap(long[] x, int i, int j) {
            final long t = x[i];
            x[i] = x[j];
            x[j] = t;
        }

        private Util() {}
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
