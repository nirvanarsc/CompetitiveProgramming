package codeforces.educational_96;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    private static final class BIT {
        private final int length;
        private final long[] data;

        private BIT(int length) {
            this.length = length;
            data = new long[length];
        }

        public void add(int idx, long val) {
            idx++;
            while (idx <= length) {
                data[idx - 1] += val;
                idx += lsb(idx);
            }
        }

        public long sum(int l, int r) {
            return sum(r) - sum(l);
        }

        public long sum(int idx) {
            long res = 0;
            while (idx > 0) {
                res += data[idx - 1];
                idx -= lsb(idx);
            }
            return res;
        }

        private static int lsb(int i) {
            return i & -i;  // zeroes all the bits except the least significant one
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final String s = fs.next();
        final Deque<Integer>[] indices = new Deque[26];
        for (int i = 0; i < 26; i++) {
            indices[i] = new ArrayDeque<>();
        }
        for (int i = 0; i < n; i++) {
            final int letter = s.charAt(i) - 'a';
            indices[letter].addLast(i);
        }
        final int[] rev = new int[n];
        for (int i = n - 1, j = 0; i >= 0; i--, j++) {
            final int letter = s.charAt(i) - 'a';
            rev[j] = indices[letter].removeFirst();
        }
        long res = 0;
        final BIT bit = new BIT(n);
        for (int id : rev) {
            res += bit.sum(id, n);
            bit.add(id, 1);
        }
        System.out.println(res);
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
