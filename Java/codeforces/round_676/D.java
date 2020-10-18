package codeforces.round_676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int x = fs.nextInt();
            final int y = fs.nextInt();
            final long c1 = fs.nextLong();
            final long c2 = fs.nextLong();
            final long c3 = fs.nextLong();
            final long c4 = fs.nextLong();
            final long c5 = fs.nextLong();
            final long c6 = fs.nextLong();
            final int skip = Math.min(Math.abs(x), Math.abs(y));
            final int diagType;
            if (skip == Math.abs(x) && x < 0 || skip == Math.abs(y) && y < 0) {
                diagType = 4;
            } else {
                diagType = 1;
            }
            long skipCost = (long) skip * (diagType == 1 ? c1 : c4);
            final long afterSkipX = diagType == 4 ? x + skip : x - skip;
            final long afterSkipY = diagType == 4 ? y + skip : y - skip;
            if (afterSkipX != 0) {
                if (afterSkipX < 0) {
                    skipCost += Math.abs(afterSkipX) * c3;
                } else {
                    skipCost += afterSkipX * c6;
                }
            }
            if (afterSkipY != 0) {
                if (afterSkipY < 0) {
                    skipCost += Math.abs(afterSkipY) * c5;
                } else {
                    skipCost += afterSkipY * c2;
                }
            }

            long noSkipCost = 0;
            if (x != 0) {
                if (x < 0) {
                    noSkipCost += (long) Math.abs(x) * c3;
                } else {
                    noSkipCost += (long) x * c6;
                }
            }
            if (y != 0) {
                if (y < 0) {
                    noSkipCost += (long) Math.abs(y) * c5;
                } else {
                    noSkipCost += (long) y * c2;
                }
            }

            System.out.println(Math.min(skipCost, noSkipCost));

        }
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
