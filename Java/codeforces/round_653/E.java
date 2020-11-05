package codeforces.round_653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int k = fs.nextInt();
        final List<Integer> a = new ArrayList<>();
        final List<Integer> b = new ArrayList<>();
        final List<Integer> both = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final int t = fs.nextInt();
            final int aa = fs.nextInt();
            final int bb = fs.nextInt();
            if (aa == 1 && bb == 1) {
                both.add(t);
            } else if (aa == 1) {
                a.add(t);
            } else if (bb == 1) {
                b.add(t);
            }
        }
        a.sort(Comparator.naturalOrder());
        b.sort(Comparator.naturalOrder());
        both.sort(Comparator.naturalOrder());
        final int common = Math.min(a.size(), b.size());
        long res = (long) 1e18;
        if (common >= k) {
            long aSum = 0;
            long bSum = 0;
            for (int i = 0; i < k; i++) {
                aSum += a.get(i);
                bSum += b.get(i);
            }
            res = Math.min(res, aSum + bSum);
            long bothSum = 0;
            for (int i = 0, j = k - 1; i < Math.min(k, both.size()); i++, j--) {
                aSum -= a.get(j);
                bSum -= b.get(j);
                bothSum += both.get(i);
                res = Math.min(res, aSum + bSum + bothSum);
            }
        } else {
            final int diff = k - common;
            long aSum = 0;
            long bSum = 0;
            for (int i = 0; i < common; i++) {
                aSum += a.get(i);
                bSum += b.get(i);
            }
            long bothSum = 0;
            if (both.size() >= diff) {
                for (int i = 0; i < diff; i++) {
                    bothSum += both.get(i);
                }
                res = Math.min(res, aSum + bSum + bothSum);
                for (int i = diff, j = common - 1; i < Math.min(k, both.size()); i++, j--) {
                    aSum -= a.get(j);
                    bSum -= b.get(j);
                    bothSum += both.get(i);
                    res = Math.min(res, aSum + bSum + bothSum);
                }
            }
        }
        System.out.println(res == (long) 1e18 ? -1 : res);
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
