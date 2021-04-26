package gcj.year_2021.round1b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 1; test <= t; test++) {
            final int n = fs.nextInt();
            final int a = fs.nextInt();
            final int b = fs.nextInt();
            final int[] u = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                u[i] = fs.nextInt();
            }
            final int g = gcd(a, b);
            int k = -1;
            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                if (u[i] > 0) {
                    if (k == -1) {
                        k = i % g;
                    } else if (k != i % g) {
                        ok = false;
                        break;
                    }
                }
            }
            if (!ok) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
                continue;
            }
            ok = false;
            for (int i = 1; i < (int) 1e4; i++) {
                if (i % g == k) {
                    final int[] l = new int[i + 1];
                    final int[] r = u.clone();
                    l[i]++;
                    if (check(l, r, a, b)) {
                        System.out.println("Case #" + test + ": " + i);
                        ok = true;
                        break;
                    }
                }
            }
            if (!ok) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean check(int[] l, int[] r, int a, int b) {
        while (true) {
            if (Arrays.equals(r, new int[r.length])) {
                return true;
            }
            if (Arrays.equals(l, new int[l.length])) {
                return false;
            }

            for (int i = l.length - 1; i >= 0; i--) {
                if (l[i] > 0) {
                    final int c = l[i];
                    l[i] = 0;
                    if (i - a >= 0) {
                        l[i - a] += c;
                    }
                    if (i - b >= 0) {
                        l[i - b] += c;
                    }
                    break;
                }
            }

            for (int i = Math.min(r.length, l.length) - 1; i >= 0; i--) {
                if (r[i] > 0 && l[i] > 0) {
                    final int min = Math.min(r[i], l[i]);
                    r[i] -= min;
                    l[i] -= min;
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
