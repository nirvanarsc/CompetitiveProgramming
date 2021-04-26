package gcj.year_2021.round1b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final int n = fs.nextInt();
        final int b = fs.nextInt();
        final long p = fs.nextLong();
        for (int test = 1; test <= t; test++) {
            final List<List<Integer>> g = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                g.add(new ArrayList<>());
            }
            outer:
            for (int i = 0; i < n * b; i++) {
                final int next = fs.nextInt();
                int res = -1;
                if (next == 9) {
                    for (int j = 0; j < n; j++) {
                        if (g.get(j).size() + 1 == b) {
                            res = j;
                            finish(g, res, 9);
                            continue outer;
                        }
                    }
                }
                if (next >= 8) {
                    for (int j = 0; j < n; j++) {
                        if (g.get(j).size() + 2 == b) {
                            res = j;
                            finish(g, res, next);
                            continue outer;
                        }
                    }
                }
                for (int j = 0; j < n; j++) {
                    if (g.get(j).size() + 2 < b) {
                        res = j;
                        finish(g, res, next);
                        continue outer;
                    }
                }
                for (int j = 0; j < n; j++) {
                    if (res == -1 || g.get(j).size() < g.get(res).size()) {
                        res = j;
                    }
                }
                finish(g, res, next);
            }
        }
        final int res = fs.nextInt();
        if (res != 1) {
            System.exit(1);
        }
    }

    private static void finish(List<List<Integer>> g, int idx, int digit) {
        g.get(idx).add(digit);
        System.out.println(idx + 1);
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
