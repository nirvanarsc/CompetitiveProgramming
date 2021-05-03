package atcoder.beginner_like.ZONeEnergy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C_BS {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[][] g = new int[n][5];
        for (int i = 0; i < n; i++) {
            g[i] = new int[] { fs.nextInt(), fs.nextInt(), fs.nextInt(), fs.nextInt(), fs.nextInt() };
        }
        int lo = 1;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (f(g, n, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(lo);
    }

    private static boolean f(int[][] g, int n, int mid) {
        final int[] masks = new int[32];
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = 0; j < 5; j++) {
                if (g[i][j] >= mid) {
                    curr |= 1 << j;
                }
            }
            masks[curr] = curr;
        }
        for (int i = 0; i < 32; i++) {
            for (int j = i + 1; j < 32; j++) {
                for (int k = j + 1; k < 32; k++) {
                    if ((masks[i] | masks[j] | masks[k]) == 31) {
                        return true;
                    }
                }
            }
        }
        return false;
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
