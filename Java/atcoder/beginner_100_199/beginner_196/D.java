package atcoder.beginner_100_199.beginner_196;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

@SuppressWarnings("TailRecursion")
public final class D {

    private static int dfs(int i, int j, int a, int b, int h, int w, boolean[][] used) {
        if (a < 0 || b < 0) {
            return 0;
        }
        if (j == w) {
            j = 0;
            i += 1;
        }
        if (i == h) {
            return 1;
        }
        if (used[i][j]) {
            return dfs(i, j + 1, a, b, h, w, used);
        }
        int res = 0;
        used[i][j] = true;
        res += dfs(i, j + 1, a, b - 1, h, w, used);
        if (j + 1 < w && !used[i][j + 1]) {
            used[i][j + 1] = true;
            res += dfs(i, j + 1, a - 1, b, h, w, used);
            used[i][j + 1] = false;
        }
        if (i + 1 < h && !used[i + 1][j]) {
            used[i + 1][j] = true;
            res += dfs(i, j + 1, a - 1, b, h, w, used);
            used[i + 1][j] = false;
        }
        used[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int h = fs.nextInt();
        final int w = fs.nextInt();
        final int a = fs.nextInt();
        final int b = fs.nextInt();
        System.out.println(dfs(0, 0, a, b, h, w, new boolean[h][w]));
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
