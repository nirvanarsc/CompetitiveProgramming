package codeforces.round_700_749.round_702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            final Map<Integer, Integer> freq = new HashMap<>();
            final Map<Integer, Integer> freq2 = new HashMap<>();
            for (int i = 0; i < n; i++) {
                freq.merge(arr[i], 1, Integer::sum);
            }
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                freq2.merge(e.getValue(), 1, Integer::sum);
            }
            long res = (long) 1e9;
            final List<int[]> pairs = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : freq2.entrySet()) {
                pairs.add(new int[] { e.getKey(), e.getValue() });
            }
            pairs.sort(Comparator.comparingInt(v -> v[0]));
            final long[] pre = new long[pairs.size() + 1];
            final long[] pre2 = new long[pairs.size() + 1];
            for (int i = 1; i <= pairs.size(); i++) {
                pre[i] = pre[i - 1] + (long) pairs.get(i - 1)[0] * pairs.get(i - 1)[1];
                pre2[i] = pre2[i - 1] + pairs.get(i - 1)[1];
            }
            for (int i = 0; i < pairs.size(); i++) {
                final long ll = pre[i];
                final long rr = pre[pairs.size()] - pre[i + 1]
                                - pairs.get(i)[0] * (pre2[pairs.size()] - pre2[i + 1]);
                res = Math.min(res, ll + rr);
            }
            System.out.println(res);
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
