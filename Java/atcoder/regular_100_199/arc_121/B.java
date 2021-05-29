package atcoder.regular_100_199.arc_121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final List<Long> red = new ArrayList<>();
        final List<Long> blue = new ArrayList<>();
        final List<Long> green = new ArrayList<>();
        for (int i = 0; i < 2 * n; i++) {
            final long a = fs.nextLong();
            final String c = fs.next();
            if ("R".equals(c)) {
                red.add(a);
            } else if ("B".equals(c)) {
                blue.add(a);
            } else {
                green.add(a);
            }
        }
        System.out.println(f(red, blue, green));
    }

    private static long f(List<Long> r, List<Long> b, List<Long> g) {
        if (r.size() % 2 != 0) {
            if (b.size() % 2 != 0) {
                final TreeSet<Long> red = new TreeSet<>(r);
                final TreeSet<Long> blue = new TreeSet<>(b);
                final long bestRB = best(red, b);
                final long bestRG = best(red, g);
                final long bestBG = best(blue, g);
                return Math.min(bestRB, bestRG + bestBG);
            } else {
                final TreeSet<Long> red = new TreeSet<>(r);
                final TreeSet<Long> green = new TreeSet<>(g);
                final long bestRG = best(red, g);
                final long bestRB = best(red, b);
                final long bestGB = best(green, b);
                return Math.min(bestRG, bestRB + bestGB);
            }
        } else if (b.size() % 2 != 0) {
            final TreeSet<Long> blue = new TreeSet<>(b);
            final TreeSet<Long> green = new TreeSet<>(g);
            final long bestBG = best(blue, g);
            final long bestBR = best(blue, r);
            final long bestGR = best(green, r);
            return Math.min(bestBG, bestBR + bestGR);
        } else {
            return 0;
        }
    }

    private static long best(TreeSet<Long> ts, List<Long> list) {
        long best = (long) 1e18;
        for (long num : list) {
            final Long floor = ts.floor(num);
            if (floor != null) {
                best = Math.min(best, Math.abs(num - floor));
            }
            final Long ceil = ts.ceiling(num);
            if (ceil != null) {
                best = Math.min(best, Math.abs(num - ceil));
            }
        }
        return best;
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
