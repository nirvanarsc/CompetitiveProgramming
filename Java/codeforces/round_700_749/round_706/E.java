package codeforces.round_700_749.round_706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final char[][] g = new char[n][m];
            for (int i = 0; i < n; i++) {
                g[i] = fs.next().toCharArray();
            }
            if (n == 1 || m == 1) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        g[i][j] = 'X';
                    }
                }
                for (int i = 0; i < n; i++) {
                    System.out.println(g[i]);
                }
                continue;
            }
            final int start = n % 3 == 0 ? 1 : 0;
            for (int i = start; i < n; i += 3) {
                for (int j = 0; j < m; j++) {
                    g[i][j] = 'X';
                }
            }
            for (int i = start + 1; i + 1 < n; i += 3) {
                int valid = getValid(m, g, i);
                if (valid != -1) {
                    g[i + 1][valid] = 'X';
                    continue;
                }
                valid = getValid(m, g, i + 1);
                if (valid != -1) {
                    g[i][valid] = 'X';
                    continue;
                }
                g[i][0] = 'X';
                g[i + 1][0] = 'X';
            }
            for (int i = 0; i < n; i++) {
                System.out.println(g[i]);
            }
        }
    }

    private static int getValid(int m, char[][] g, int i) {
        int valid = -1;
        for (int j = 0; j < m; j++) {
            if (g[i][j] == 'X') {
                valid = j;
                break;
            }
        }
        return valid;
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
