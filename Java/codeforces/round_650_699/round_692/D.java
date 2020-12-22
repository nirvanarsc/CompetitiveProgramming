package codeforces.round_650_699.round_692;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final char[] s = fs.next().toCharArray();
        final int n = s.length;
        final int x = fs.nextInt();
        final int y = fs.nextInt();
        final int[] pre1 = new int[n + 1];
        final int[] pre0 = new int[n + 1];
        final int[] preQ = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre1[i] = pre1[i - 1] + (s[i - 1] == '1' ? 1 : 0);
            pre0[i] = pre0[i - 1] + (s[i - 1] == '0' ? 1 : 0);
            preQ[i] = preQ[i - 1] + (s[i - 1] == '?' ? 1 : 0);
        }
        long xx = 0;
        long yy = 0;
        long curr;
        if (x < y) {
            for (int i = 0; i < n; i++) {
                if (s[i] == '?' || s[i] == '0') {
                    xx += pre1[n] - pre1[i];
                } else {
                    yy += pre0[n] - pre0[i];
                    yy += preQ[n] - preQ[i];
                }
            }
            curr = xx * x + yy * y;
            for (int i = n - 1; i >= 0; i--) {
                if (s[i] == '?') {
                    xx -= preQ[n] - preQ[i + 1];
                    xx -= pre1[n] - pre1[i];
                    xx += pre0[i];
                    xx += preQ[i];

                    yy -= pre1[i];
                    yy += pre0[n] - pre0[i];
                    curr = Math.min(curr, xx * x + yy * y);
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (s[i] == '?' || s[i] == '1') {
                    yy += pre0[n] - pre0[i];
                } else {
                    xx += pre1[n] - pre1[i];
                    xx += preQ[n] - preQ[i];
                }
            }
            curr = xx * x + yy * y;
            for (int i = n - 1; i >= 0; i--) {
                if (s[i] == '?') {
                    yy -= preQ[n] - preQ[i + 1];
                    yy -= pre0[n] - pre0[i];
                    yy += pre1[i];
                    yy += preQ[i];

                    xx -= pre0[i];
                    xx += pre1[n] - pre1[i];
                    curr = Math.min(curr, xx * x + yy * y);
                }
            }
        }
        System.out.println(curr);
    }

    static final class Utils {
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
