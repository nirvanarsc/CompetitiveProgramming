package atcoder.regular_100_199.arc_117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class A {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int a = fs.nextInt();
        final int b = fs.nextInt();
        final int[] pos = new int[a];
        final int[] neg = new int[b];
        int sum = 0;
        if (a >= b) {
            for (int i = 0; i < pos.length; i++) {
                pos[i] = i + 1;
                sum += pos[i];
            }
            for (int i = 0; i < neg.length - 1; i++) {
                neg[i] = -(i + 1);
                sum += neg[i];
            }
            neg[neg.length - 1] = -sum;
        } else {
            for (int i = 0; i < neg.length; i++) {
                neg[i] = -(i + 1);
                sum += neg[i];
            }
            for (int i = 0; i < pos.length - 1; i++) {
                pos[i] = i + 1;
                sum += pos[i];
            }
            pos[pos.length - 1] = -sum;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a; i++) {
            sb.append(pos[i]);
            sb.append(' ');
        }
        for (int i = 0; i < b; i++) {
            sb.append(neg[i]);
            sb.append(' ');
        }
        System.out.println(sb);
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
