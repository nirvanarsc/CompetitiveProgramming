package codeforces.round_700_749.round_708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            final int[] f = new int[m];
            for (int i = 0; i < n; i++) {
                f[arr[i] % m]++;
            }
            int res = f[0] > 0 ? 1 : 0;
            if (m % 2 == 0) {
                for (int i = 1, j = m - 1; i < m / 2; i++, j--) {
                    if (f[i] != 0 && f[j] != 0) {
                        res++;
                        if (f[i] != f[j]) {
                            final int max = Math.max(f[i], f[j]);
                            final int min = Math.min(f[i], f[j]);
                            res += max - min - 1;
                        }
                    } else if (f[i] != 0) {
                        res += f[i];
                    } else if (f[j] != 0) {
                        res += f[j];
                    }
                }
                if (f[m / 2] > 0) {
                    res++;
                }
            } else {
                for (int i = 1, j = m - 1; i <= m / 2; i++, j--) {
                    if (f[i] != 0 && f[j] != 0) {
                        res++;
                        if (f[i] != f[j]) {
                            final int max = Math.max(f[i], f[j]);
                            final int min = Math.min(f[i], f[j]);
                            res += max - min - 1;
                        }
                    } else if (f[i] != 0) {
                        res += f[i];
                    } else if (f[j] != 0) {
                        res += f[j];
                    }
                }
            }
            System.out.println(res);
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
