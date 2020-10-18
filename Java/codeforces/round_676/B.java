package codeforces.round_676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final char[][] grid = new char[n][n];
            for (int i = 0; i < n; i++) {
                grid[i] = fs.next().toCharArray();
            }
            final int startR = grid[0][1] - '0';
            final int startD = grid[1][0] - '0';
            final int endU = grid[n - 2][n - 1] - '0';
            final int endL = grid[n - 1][n - 2] - '0';
            if (startR == 0 && startD == 0) {
                if (endU == 1 && endL == 1) {
                    pw.println(0);
                    continue;
                }
                if (endU == 0 && endL == 1) {
                    pw.println(1);
                    pw.println((n - 1) + " " + n);
                    continue;
                }
                if (endU == 1 && endL == 0) {
                    pw.println(1);
                    pw.println(n + " " + (n - 1));
                    continue;
                }
                pw.println(2);
                pw.println((n - 1) + " " + n);
                pw.println(n + " " + (n - 1));
                continue;
            } else if (startR == 0 && startD == 1) {
                if (endU == 1 && endL == 1) {
                    pw.println(1);
                    pw.println(1 + " " + 0);
                    continue;
                }
                if (endU == 0 && endL == 1) {
                    pw.println(2);
                    pw.println((n - 1) + " " + n);
                    pw.println(2 + " " + 1);
                    continue;
                }
                if (endU == 1 && endL == 0) {
                    pw.println(2);
                    pw.println(n + " " + (n - 1));
                    pw.println(2 + " " + 1);
                    continue;
                }
                pw.println(1);
                pw.println(1 + " " + 2);
                continue;
            } else if (startR == 1 && startD == 0) {
                if (endU == 1 && endL == 1) {
                    pw.println(1);
                    pw.println(1 + " " + 2);
                    continue;
                }
                if (endU == 0 && endL == 1) {
                    pw.println(2);
                    pw.println((n - 1) + " " + n);
                    pw.println(1 + " " + 2);
                    continue;
                }
                if (endU == 1 && endL == 0) {
                    pw.println(2);
                    pw.println(n + " " + (n - 1));
                    pw.println(1 + " " + 2);
                    continue;
                }
                pw.println(1);
                pw.println(2 + " " + 1);
                continue;
            } else {
                if (endU == 1 && endL == 1) {
                    pw.println(2);
                    pw.println((n - 1) + " " + n);
                    pw.println(n + " " + (n - 1));
                    continue;
                }
                if (endU == 0 && endL == 1) {
                    pw.println(1);
                    pw.println(n + " " + (n - 1));
                    continue;
                }
                if (endU == 1 && endL == 0) {
                    pw.println(1);
                    pw.println((n - 1) + " " + n);
                    continue;
                }
                pw.println(0);
                continue;
            }
        }
        pw.close();
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
