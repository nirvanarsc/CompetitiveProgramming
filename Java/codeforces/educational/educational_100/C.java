package codeforces.educational.educational_100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int testCount = fs.nextInt();
        for (int test = 0; test < testCount; test++) {
            final int n = fs.nextInt();
            final int[] x = new int[n];
            final int[] t = new int[n];
            for (int i = 0; i < n; i++) {
                t[i] = fs.nextInt();
                x[i] = fs.nextInt();
            }
            long dest = 0;
            long goal = (long) -1e18;
            long pos = 0;
            long currT = 0;
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (f1(dest, goal, pos) && (goal - pos <= t[i] - currT)) {
                    res++;
                } else if (f2(dest, goal, pos) && (pos - goal <= t[i] - currT)) {
                    res++;
                }
                if (Math.abs(dest - pos) <= t[i] - currT) {
                    pos = dest;
                } else if (dest > pos) {
                    pos += t[i] - currT;
                } else if (dest < pos) {
                    pos -= t[i] - currT;
                }
                currT = t[i];
                if (pos == dest) {
                    dest = x[i];
                }
                goal = x[i];
            }
            if (f1(dest, goal, pos) || f2(dest, goal, pos)) {
                res++;
            }
            System.out.println(res);
        }
    }

    private static boolean f1(long dest, long goal, long pos) {
        return pos <= goal && goal <= dest;
    }

    private static boolean f2(long dest, long goal, long pos) {
        return pos >= goal && goal >= dest;
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
