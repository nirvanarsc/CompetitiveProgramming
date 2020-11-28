package codeforces.round_600_649.round_635;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int r = fs.nextInt();
            final int b = fs.nextInt();
            final int g = fs.nextInt();
            final TreeSet<Integer> red = new TreeSet<>();
            final TreeSet<Integer> blue = new TreeSet<>();
            final TreeSet<Integer> green = new TreeSet<>();
            for (int i = 0; i < r; i++) {
                red.add(fs.nextInt());
            }
            for (int i = 0; i < b; i++) {
                blue.add(fs.nextInt());
            }
            for (int i = 0; i < g; i++) {
                green.add(fs.nextInt());
            }
            final long[] best = { (long) 9e18 };
            process(red, blue, green, best);
            process(blue, red, green, best);
            process(green, red, blue, best);
            System.out.println(best[0]);
        }
    }

    private static void process(TreeSet<Integer> red, TreeSet<Integer> blue, TreeSet<Integer> green,
                                long[] best) {
        for (int mid : red) {
            final Integer floorG = green.floor(mid);
            final Integer ceilG = green.ceiling(mid);
            final Integer floorB = blue.floor(mid);
            final Integer ceilB = blue.ceiling(mid);
            if (floorG != null && ceilB != null) {
                best[0] = Math.min(best[0], f(floorG, mid, ceilB));
            }
            if (floorB != null && ceilG != null) {
                best[0] = Math.min(best[0], f(floorB, mid, ceilG));
            }
        }
    }

    private static long f(int x, int y, int z) {
        long res = 0;
        res += (long) (x - y) * (x - y);
        res += (long) (y - z) * (y - z);
        res += (long) (z - x) * (z - x);
        return res;
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
