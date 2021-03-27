package gcj.year_2021.qualifying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int x = 1; x <= t; x++) {
            final int n = fs.nextInt();
            int c = fs.nextInt();
            final int lo = n - 1;
            final int hi = ((n * (n + 1)) / 2) - 1;
            if (lo > c || c > hi) {
                System.out.println("Case #" + x + ": IMPOSSIBLE");
                continue;
            }
            c -= lo;
            final StringBuilder sb = new StringBuilder();
            final int[] res = f(n, c);
            for (int i = 0; i < n; i++) {
                sb.append(res[i]);
                sb.append(' ');
            }
            System.out.println("Case #" + x + ": " + sb);
        }
    }

    private static int[] f(int n, int k) {
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i + 1;
        }
        int lo = 0;
        int hi = n - 1;
        boolean turn = true;
        while (k > 0) {
            final int idx = Math.min(hi - lo, k);
            k -= idx;
            reverse(res, lo, lo + idx);
            if (turn) {
                hi--;
            } else {
                lo++;
            }
            turn ^= true;
        }
        return res;
    }

    private static void reverse(int[] nums, int from, int to) {
        while (from < to) {
            final int t = nums[from];
            nums[from] = nums[to];
            nums[to] = t;
            from++;
            to--;
        }
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
