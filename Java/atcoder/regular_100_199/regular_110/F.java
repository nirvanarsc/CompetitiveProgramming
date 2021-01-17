package atcoder.regular_100_199.regular_110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final PrintWriter pw = new PrintWriter(System.out);
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final List<Integer> arr = new ArrayList<>(n);
        final List<Integer> inv = new ArrayList<>(n);
        final List<Integer> res = new ArrayList<>(n);
        final Random r = new Random();
        for (int i = 0; i < n; i++) {
            arr.add(fs.nextInt());
            inv.add(-1);
        }
        for (int i = 0; i < n; i++) {
            inv.set(arr.get(i), i);
        }
        for (int i = 0; i < 1000; i++) {
            f(r.nextInt(n), n, arr, inv, res);
        }
        while (!isSorted(n, arr)) {
            final int id = inv.get(1);
            for (int i = 1; arr.get(id) == i && i < n; i++) {
                f(id, n, arr, inv, res);
            }
        }
        System.out.println(res.size());
        for (int op : res) {
            pw.println(op);
        }
        pw.flush();
    }

    private static boolean isSorted(int n, List<Integer> arr) {
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            ok &= arr.get(i) == i;
        }
        return ok;
    }

    private static void f(int i, int n, List<Integer> a, List<Integer> inv, List<Integer> ans) {
        if (a.get(i) == 0) {
            return;
        }
        ans.add(i);
        final int j = (i + a.get(i)) % n;
        Collections.swap(inv, a.get(i), a.get(j));
        Collections.swap(a, i, j);
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
