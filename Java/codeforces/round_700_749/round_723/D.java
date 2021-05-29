package codeforces.round_700_749.round_723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

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

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final String str = "ANTO";
        final StringBuilder sb = new StringBuilder();
        for (int test = 0; test < t; test++) {
            final char[] w = fs.next().toCharArray();
            final int[] f = new int[4];
            for (char c : w) {
                f[str.indexOf(c)]++;
            }
            long max = 0;
            String best = "ANTO";
            List<Integer> p = Arrays.asList(0, 1, 2, 3);
            while (!p.isEmpty()) {
                final BIT bit = new BIT(4);
                long inv = 0;
                for (int i = w.length - 1; i >= 0; i--) {
                    bit.add(p.indexOf(str.indexOf(w[i])), 1);
                    inv += bit.sum(p.indexOf(str.indexOf(w[i])), 3);
                }
                long curr = 0;
                curr += (long) (f[p.get(0)] + f[p.get(1)] + f[p.get(2)]) * f[p.get(3)];
                curr += (long) (f[p.get(0)] + f[p.get(1)]) * f[p.get(2)];
                curr += (long) f[p.get(0)] * f[p.get(1)];
                if (2 * inv > curr && inv > max) {
                    max = inv;
                    final StringBuilder currIdx = new StringBuilder();
                    for (int i = 3; i >= 0; i--) {
                        currIdx.append(str.charAt(p.get(i)));
                    }
                    best = currIdx.toString();
                }
                p = nextPermutation(p);
            }
            for (int i = 0; i < 4; i++) {
                final char c = best.charAt(i);
                final int idx = str.indexOf(c);
                while (f[idx]-- > 0) {
                    sb.append(c);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static List<Integer> nextPermutation(List<Integer> perm) {
        int swapIdx = -1;
        final int n = perm.size();
        for (int i = n - 1; i >= 1; i--) {
            if (perm.get(i - 1) < perm.get(i)) {
                swapIdx = i - 1;
                break;
            }
        }
        if (swapIdx == -1) {
            return Collections.emptyList();
        }
        for (int i = n - 1; i >= 1; i--) {
            if (perm.get(i) > perm.get(swapIdx)) {
                Collections.swap(perm, swapIdx, i);
                break;
            }
        }
        Collections.reverse(perm.subList(swapIdx + 1, perm.size()));
        return perm;
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
