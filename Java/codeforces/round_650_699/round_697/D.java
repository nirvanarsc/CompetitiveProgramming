package codeforces.round_650_699.round_697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final List<Integer> one = new ArrayList<>();
            final List<Integer> two = new ArrayList<>();
            final int[] mm = fs.nextIntArray(n);
            final int[] cc = fs.nextIntArray(n);
            for (int i = 0; i < n; i++) {
                if (cc[i] == 1) {
                    one.add(mm[i]);
                } else {
                    two.add(mm[i]);
                }
            }
            one.sort(Comparator.reverseOrder());
            two.sort(Comparator.reverseOrder());
            final TreeMap<Long, Integer> tm = new TreeMap<>();
            long pre = 0;
            tm.put(pre, 0);
            for (int i = 0, j = 2; i < two.size(); i++, j += 2) {
                pre += two.get(i);
                tm.put(pre, j);
            }
            int res = (int) 1e9;
            long curr = 0;
            Map.Entry<Long, Integer> ceil = tm.ceilingEntry((long) m);
            if (ceil != null) {
                res = Math.min(res, ceil.getValue());
            }
            for (int i = 0; i < one.size(); i++) {
                curr += one.get(i);
                final long comp = m - curr;
                if (comp <= 0) {
                    res = Math.min(res, i + 1);
                    break;
                }
                ceil = tm.ceilingEntry(comp);
                if (ceil != null) {
                    res = Math.min(res, i + 1 + ceil.getValue());
                }
            }
            System.out.println(res == (int) 1e9 ? -1 : res);
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
