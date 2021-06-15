package codeforces.custom.LATOKEN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class A {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final StringBuilder sb = new StringBuilder();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final char[][] g = new char[n][m];
            for (int i = 0; i < n; i++) {
                g[i] = fs.next().toCharArray();
            }
            if (ok(g, n, m, 'R')) {
                sb.append("YES\n");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if ((i + j) % 2 == 0) {
                            sb.append('R');
                        } else {
                            sb.append('W');
                        }
                    }
                    sb.append('\n');
                }
            } else if (ok(g, n, m, 'W')) {
                sb.append("YES\n");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if ((i + j) % 2 == 0) {
                            sb.append('W');
                        } else {
                            sb.append('R');
                        }
                    }
                    sb.append('\n');
                }
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean ok(char[][] g, int n, int m, char c) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] != '.') {
                    if ((i + j) % 2 == 0) {
                        if (g[i][j] != c) {
                            return false;
                        }
                    } else {
                        if (g[i][j] == c) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
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
