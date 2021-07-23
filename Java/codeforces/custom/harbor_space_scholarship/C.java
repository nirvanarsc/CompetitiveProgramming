package codeforces.custom.harbor_space_scholarship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final char[] w = fs.next().toCharArray();
            int min = 10;
            for (int mask = 0; mask < (1 << 10); mask++) {
                boolean ok = true;
                for (int i = 0; i < 10; i++) {
                    if (w[i] != '?') {
                        final int setBit = (mask & (1 << i)) != 0 ? 1 : 0;
                        if (setBit != w[i] - '0') {
                            ok = false;
                            break;
                        }
                    }
                }
                if (!ok) {
                    continue;
                }
                int l = 0;
                int remL = 5;
                int r = 0;
                int remR = 5;
                for (int i = 0; i < 10; i++) {
                    if (i % 2 == 0) {
                        remL--;
                        if ((mask & (1 << i)) != 0) {
                            l++;
                        }
                    } else {
                        remR--;
                        if ((mask & (1 << i)) != 0) {
                            r++;
                        }
                    }
                    if (l + remL < r || r + remR < l) {
                        min = Math.min(min, i + 1);
                        break;
                    }
                }
            }
            System.out.println(min);
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
