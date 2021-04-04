package codeforces.round_700_749.round_712;

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
        outer:
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final char[] w1 = fs.next().toCharArray();
            final char[] w2 = fs.next().toCharArray();
            final int[] l0 = new int[w1.length + 1];
            final int[] l1 = new int[w1.length + 1];
            for (int i = 1; i <= n; i++) {
                l0[i] = l0[i - 1] + (w1[i - 1] == '0' ? 1 : 0);
                l1[i] = l1[i - 1] + (w1[i - 1] == '1' ? 1 : 0);
            }
            boolean flag = false;
            for (int i = n - 1; i >= 0; i--) {
                if ((!flag && w1[i] != w2[i]) || (flag && w1[i] == w2[i])) {
                    if (l0[i + 1] != l1[i + 1]) {
                        System.out.println("NO");
                        continue outer;
                    } else {
                        int j = i;
                        if (!flag) {
                            while (j >= 0 && (w1[j] != w2[j])) {
                                j--;
                            }
                        } else {
                            while (j >= 0 && (w1[j] == w2[j])) {
                                j--;
                            }
                        }
                        flag ^= true;
                        i = j + 1;
                    }
                }
            }
            System.out.println("YES");
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
