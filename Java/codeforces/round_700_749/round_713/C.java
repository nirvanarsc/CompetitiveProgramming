package codeforces.round_700_749.round_713;

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
        outer:
        for (int test = 0; test < t; test++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            final char[] w = fs.next().toCharArray();
            int lo = 0;
            int hi = w.length - 1;
            while (lo < hi) {
                if (w[lo] == '?' && w[hi] == '?') {
                    lo++;
                    hi--;
                } else if (w[lo] == '?') {
                    if (w[hi] == '0') {
                        if (a < 2) {
                            System.out.println(-1);
                            continue outer;
                        } else {
                            w[lo] = '0';
                            a -= 2;
                            lo++;
                            hi--;
                        }
                    } else {
                        if (b < 2) {
                            System.out.println(-1);
                            continue outer;
                        } else {
                            w[lo] = '1';
                            b -= 2;
                            lo++;
                            hi--;
                        }
                    }
                } else if (w[hi] == '?') {
                    if (w[lo] == '0') {
                        if (a < 2) {
                            System.out.println(-1);
                            continue outer;
                        } else {
                            w[hi] = '0';
                            a -= 2;
                            lo++;
                            hi--;
                        }
                    } else {
                        if (b < 2) {
                            System.out.println(-1);
                            continue outer;
                        } else {
                            w[hi] = '1';
                            b -= 2;
                            lo++;
                            hi--;
                        }
                    }
                } else if (w[lo] != w[hi]) {
                    System.out.println(-1);
                    continue outer;
                } else {
                    if (w[lo] == '0') {
                        if (a < 2) {
                            System.out.println(-1);
                            continue outer;
                        }
                        a -= 2;
                    } else {
                        if (b < 2) {
                            System.out.println(-1);
                            continue outer;
                        }
                        b -= 2;
                    }
                    lo++;
                    hi--;
                }
            }
            lo = 0;
            hi = w.length - 1;
            while (lo < hi) {
                if (w[lo] == '?' && w[hi] == '?') {
                    if (a >= 2) {
                        w[lo] = w[hi] = '0';
                        a -= 2;
                    } else if (b >= 2) {
                        w[lo] = w[hi] = '1';
                        b -= 2;
                    } else {
                        System.out.println(-1);
                        continue outer;
                    }
                }
                lo++;
                hi--;
            }
            if (w.length % 2 != 0) {
                if (w[w.length / 2] == '?') {
                    if (a > 0) {
                        w[w.length / 2] = '0';
                        a--;
                    } else if (b > 0) {
                        w[w.length / 2] = '1';
                        b--;
                    } else {
                        System.out.println(-1);
                        continue;
                    }
                } else if (w[w.length / 2] == '1') {
                    b--;
                } else {
                    a--;
                }
            }
            if (a == 0 && b == 0) {
                System.out.println(w);
            } else {
                System.out.println(-1);
            }
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
