package codeforces.round_700_749.round_715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final char[] w1 = fs.next().toCharArray();
            final char[] w2 = fs.next().toCharArray();
            final char[] w3 = fs.next().toCharArray();
            final int[] f1 = new int[2];
            final int[] f2 = new int[2];
            final int[] f3 = new int[2];
            for (int i = 0; i < 2 * n; i++) {
                f1[w1[i] - '0']++;
                f2[w2[i] - '0']++;
                f3[w3[i] - '0']++;
            }
            StringBuilder sb = new StringBuilder();
            if (f1[0] >= n && f2[0] >= n) {
                sb = f(w1, w2, n, Math.min(f1[0], f2[0]), '0', '1');
            } else if (f1[0] >= n && f3[0] >= n) {
                sb = f(w1, w3, n, Math.min(f1[0], f3[0]), '0', '1');
            } else if (f2[0] >= n && f3[0] >= n) {
                sb = f(w2, w3, n, Math.min(f2[0], f3[0]), '0', '1');
            } else if (f1[1] >= n && f2[1] >= n) {
                sb = f(w1, w2, n, Math.min(f1[1], f2[1]), '1', '0');
            } else if (f1[1] >= n && f3[1] >= n) {
                sb = f(w1, w3, n, Math.min(f1[1], f3[1]), '1', '0');
            } else if (f2[1] >= n && f3[1] >= n) {
                sb = f(w2, w3, n, Math.min(f2[1], f3[1]), '1', '0');
            }
            System.out.println(sb);
        }
    }

    private static StringBuilder f(char[] f1, char[] f2, int n, int toMatch, char common, char other) {
        final StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < 2 * n && j < 2 * n && toMatch > 0) {
            while (i < 2 * n && f1[i] != common) {
                sb.append(other);
                i++;
            }
            while (j < 2 * n && f2[j] != common) {
                sb.append(other);
                j++;
            }
            sb.append(common);
            i++;
            j++;
            toMatch--;
        }
        while (i < 2 * n || j < 2 * n) {
            if (i < 2 * n && j < 2 * n) {
                if (f1[i] != f2[j]) {
                    sb.append(common);
                }
                sb.append(other);
                i++;
                j++;
            } else if (i < 2 * n) {
                sb.append(f1[i++]);
            } else {
                sb.append(f2[j++]);
            }
        }
        while (sb.length() < 3 * n) {
            sb.append(other);
        }
        return sb;
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
