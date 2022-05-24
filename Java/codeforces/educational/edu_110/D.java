package codeforces.educational.edu_110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final StringBuilder sb = new StringBuilder();
        final int k = fs.nextInt();
        final char[] w = new StringBuilder(fs.next()).reverse().toString().toCharArray();
        final int n = (1 << k) - 1;
        final int[] tree = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            tree[i] = update(w, n, tree, i);
        }
        final int q = fs.nextInt();
        for (int i = 0; i < q; i++) {
            int idx = n - fs.nextInt();
            final char c = fs.next().charAt(0);
            w[idx] = c;
            while (idx != -1) {
                tree[idx] = update(w, n, tree, idx);
                idx = getP(idx);
            }
            sb.append(tree[0]);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int update(char[] w, int n, int[] tree, int i) {
        int res = 0;
        if (getL(i) < n && getR(i) < n) {
            if (w[i] == '?') {
                res += tree[getL(i)];
                res += tree[getR(i)];
            } else if (w[i] == '1') {
                res += tree[getL(i)];
            } else {
                res += tree[getR(i)];
            }
        } else {
            if (w[i] == '?') {
                res = 2;
            } else {
                res = 1;
            }
        }
        return res;
    }

    private static int getL(int n) {
        return 2 * n + 1;
    }

    private static int getR(int n) {
        return 2 * n + 2;
    }

    private static int getP(int n) {
        if (n == 0) {
            return -1;
        }
        return (n - 1) / 2;
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
