package codeforces.round_700_749.round_710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;

@SuppressWarnings("ConstantConditions")
public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[] arr = new int[n];
            final TreeSet<Integer> ts1 = new TreeSet<>();
            final TreeSet<Integer> ts2 = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                ts1.add(i + 1);
                ts2.add(i + 1);
                arr[i] = fs.nextInt();
            }
            final int[] min = new int[n];
            final int[] max = new int[n];
            min[0] = max[0] = arr[0];
            ts1.remove(arr[0]);
            ts2.remove(arr[0]);
            for (int i = 1; i < n; i++) {
                if (arr[i] != arr[i - 1]) {
                    ts1.remove(arr[i]);
                    ts2.remove(arr[i]);
                    min[i] = max[i] = arr[i];
                }
            }
            for (int i = 1; i < n; i++) {
                if (max[i] != 0) {
                    continue;
                }
                final int v = ts2.lower(max[i - 1]);
                min[i] = ts1.pollFirst();
                max[i] = v;
                ts2.remove(v);
            }
            final StringBuilder sb1 = new StringBuilder();
            final StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb1.append(min[i]);
                sb1.append(' ');
                sb2.append(max[i]);
                sb2.append(' ');
            }
            System.out.println(sb1);
            System.out.println(sb2);
        }
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
