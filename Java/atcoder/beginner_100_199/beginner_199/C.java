package atcoder.beginner_100_199.beginner_199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final char[] w = fs.next().toCharArray();
        final int q = fs.nextInt();
        boolean flag = false;
        for (int i = 0; i < q; i++) {
            final int t = fs.nextInt();
            int a = fs.nextInt() - 1;
            int b = fs.nextInt() - 1;
            if (t == 1) {
                if (flag) {
                    if (a < n) {
                        a += n;
                    } else {
                        a -= n;
                    }
                    if (b < n) {
                        b += n;
                    } else {
                        b -= n;
                    }
                }
                final char temp = w[a];
                w[a] = w[b];
                w[b] = temp;
            } else {
                flag ^= true;
            }
        }
        final StringBuilder sb = new StringBuilder();
        if (flag) {
            for (int i = n; i < 2 * n; i++) {
                sb.append(w[i]);
            }
            for (int i = 0; i < n; i++) {
                sb.append(w[i]);
            }
        } else {
            for (int i = 0; i < 2 * n; i++) {
                sb.append(w[i]);
            }
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
