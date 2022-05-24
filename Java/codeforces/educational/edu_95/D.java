package codeforces.educational.edu_95;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        final TreeSet<Integer> ts = new TreeSet<>();
        final TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            ts.add(fs.nextInt());
        }
        final Iterator<Integer> iterator = ts.iterator();
        int prev = -1;
        while (iterator.hasNext()) {
            final int curr = iterator.next();
            if (prev != -1) {
                tm.merge(curr - prev, 1, Integer::sum);
            }
            prev = curr;
        }
        pw.println(ts.size() > 1 ? (ts.last() - ts.first() - tm.lastKey()) : 0);
        for (int i = 0; i < q; i++) {
            final int type = fs.nextInt();
            final int idx = fs.nextInt();
            final Integer higher = ts.higher(idx);
            final Integer lower = ts.lower(idx);
            if (type == 0) {
                ts.remove(idx);
                if (higher != null && lower != null) {
                    tm.merge(higher - lower, 1, Integer::sum);
                    decRemove(tm, higher, idx);
                    decRemove(tm, idx, lower);
                } else if (higher != null) {
                    decRemove(tm, higher, idx);
                } else if (lower != null) {
                    decRemove(tm, idx, lower);
                }
            } else {
                ts.add(idx);
                if (higher != null && lower != null) {
                    decRemove(tm, higher, lower);
                    tm.merge(idx - lower, 1, Integer::sum);
                    tm.merge(higher - idx, 1, Integer::sum);
                } else if (higher != null) {
                    tm.merge(higher - idx, 1, Integer::sum);
                } else if (lower != null) {
                    tm.merge(idx - lower, 1, Integer::sum);
                }
            }
            pw.println(ts.size() > 1 ? (ts.last() - ts.first() - tm.lastKey()) : 0);
        }
        pw.close();
    }

    private static void decRemove(TreeMap<Integer, Integer> tm, Integer higher, Integer lower) {
        tm.merge(higher - lower, -1, Integer::sum);
        if (tm.get(higher - lower) == 0) {
            tm.remove(higher - lower);
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
