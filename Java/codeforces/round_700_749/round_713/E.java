package codeforces.round_700_749.round_713;

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
            final int l = fs.nextInt();
            final int r = fs.nextInt();
            int s = fs.nextInt();
            final TreeSet<Integer> ts = new TreeSet<>();
            for (int i = 1; i <= n; i++) {
                ts.add(i);
            }
            int k = r - l + 1;
            int min = 0;
            int max = 0;
            for (int i = 1, j = n; i <= k; i++, j--) {
                min += i;
                max += j;
            }
            if (!(min <= s && s <= max)) {
                System.out.println(-1);
                continue;
            }
            final int[] res = new int[n];
            for (int i = l - 1; i < r; i++) {
                if (s == (k * (k + 1)) / 2) {
                    for (int j = i, p = 1; j < r; j++) {
                        res[j] = p++;
                    }
                    break;
                } else {
                    final int minRem = (k * (k - 1)) / 2;
                    if (s - minRem > ts.last()) {
                        res[i] = ts.pollLast();
                        s -= res[i];
                    } else {
                        res[i] = s - minRem;
                        ts.remove(s - minRem);
                        s = minRem;
                    }
                    k--;
                }
            }
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (res[i] == 0) {
                    res[i] = ts.pollLast();
                }
                sb.append(res[i]);
                sb.append(' ');
            }
            System.out.println(sb);
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
