package codeforces.round_700_749.round_734;

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
            final int m = fs.nextInt();
            final int k = fs.nextInt();
            final int l = ((n * m) / 2) - k;
            char[][] g = new char[n][m];
            for (char[] row : g) {
                Arrays.fill(row, '*');
            }
            f1(g, n, m, k);
            f2(g, n, m, l);
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (g[i][j] == '*') {
                        ok = false;
                        break;
                    }
                }
            }
            if (!ok) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                for (int i = 0; i < n; i++) {
                    System.out.println(g[i]);
                }
            }
        }
    }

    private static void f1(char[][] g, int n, int m, int k) {
        if (m % 2 != 0 || n % 2 == 0) {
            for (int j = 0; j < m; j += 2) {
                for (int i = 0; i < n; i++) {
                    if (k == 0) {
                        return;
                    }
                    if (j + 1 < m) {
                        char c = 'a';
                        if (j > 0) {
                            if (g[i][j - 1] == 'a') {
                                c = 'b';
                            } else if (g[i][j - 1] == 'b') {
                                c = 'a';
                            }
                        }
                        if (i > 0) {
                            if (g[i - 1][j] == 'a') {
                                c = 'b';
                            } else if (g[i - 1][j] == 'b') {
                                c = 'a';
                            }
                        }
                        g[i][j] = c;
                        g[i][j + 1] = c;
                        k--;
                    }
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j += 2) {
                    if (k == 0) {
                        return;
                    }
                    char c = 'a';
                    if (j > 0) {
                        if (g[i][j - 1] == 'a') {
                            c = 'b';
                        } else if (g[i][j - 1] == 'b') {
                            c = 'a';
                        }
                    }
                    if (i > 0) {
                        if (g[i - 1][j] == 'a') {
                            c = 'b';
                        } else if (g[i - 1][j] == 'b') {
                            c = 'a';
                        }
                    }
                    g[i][j] = c;
                    g[i][j + 1] = c;
                    k--;
                }
            }
        }
    }

    private static void f2(char[][] g, int n, int m, int k) {
        if (m % 2 != 0 || n % 2 == 0) {
            for (int j = 0; j < m; j++) {
                for (int i = 0; i < n; i += 2) {
                    if (k == 0) {
                        return;
                    }
                    if (g[i][j] == '*' && (i + 1) < n) {
                        int mask = 0;
                        if (j > 0 && g[i][j - 1] >= 'c') {
                            mask |= 1 << g[i][j - 1] - 'c';
                        }
                        if (i > 0 && g[i - 1][j] >= 'c') {
                            mask |= 1 << g[i - 1][j] - 'c';
                        }
                        char c;
                        if (mask == 3) {
                            c = 'e';
                        } else if (mask == 1 || mask == 5) {
                            c = 'd';
                        } else {
                            c = 'c';
                        }
                        g[i][j] = c;
                        g[i + 1][j] = c;
                        k--;
                    }
                }
            }
        } else {
            for (int i = 0; i < n; i += 2) {
                for (int j = 0; j < m; j++) {
                    if (k == 0) {
                        return;
                    }
                    if (g[i][j] == '*' && (i + 1) < n) {
                        int mask = 0;
                        if (j > 0 && g[i][j - 1] >= 'c') {
                            mask |= 1 << g[i][j - 1] - 'c';
                        }
                        if (i > 0 && g[i - 1][j] >= 'c') {
                            mask |= 1 << g[i - 1][j] - 'c';
                        }
                        char c;
                        if (mask == 3) {
                            c = 'e';
                        } else if (mask == 1 || mask == 5) {
                            c = 'd';
                        } else {
                            c = 'c';
                        }
                        g[i][j] = c;
                        g[i + 1][j] = c;
                        k--;
                    }
                }
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
