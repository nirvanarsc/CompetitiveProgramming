package codeforces.round_700_749.round_715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner sc = new FastScanner();
        final StringBuilder sb = new StringBuilder();
        final int q = sc.nextInt();
        for (int query = 0; query < q; query++) {
            final int n = sc.nextInt();
            long k = sc.nextLong();
            if (n <= 61 && k > (1L << (n - 1))) {
                sb.append(-1);
                sb.append('\n');
                continue;
            }
            final int[] res = new int[n];
            int idx = 0;
            int min = 1;
            while (idx < n) {
                if (n - idx >= 62) {
                    res[idx] = min;
                    idx++;
                    min++;
                } else {
                    long s = 0;
                    long d = 0;
                    int next = n;
                    for (int i = min; i <= n; i++) {
                        s += 1L << (n - 1 - i);
                        if (k <= s) {
                            next = i;
                            break;
                        }
                        d = s;
                    }
                    for (int i = next; i >= min; i--) {
                        res[idx] = i;
                        idx++;
                    }
                    k -= d;
                    min = next + 1;
                }
            }
            for (int num : res) {
                sb.append(num);
                sb.append(' ');
            }
            sb.append('\n');
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
