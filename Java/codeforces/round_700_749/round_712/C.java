package codeforces.round_700_749.round_712;

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
            final int n = fs.nextInt();
            final char[] w = fs.next().toCharArray();
            final char[] l = new char[n];
            final char[] r = new char[n];
            int o1 = 0;
            int o2 = 0;
            for (int i = 0; i < n; i++) {
                if (w[i] == '0') {
                    if (o1 == 0 && o2 == 0) {
                        System.out.println("NO");
                        continue outer;
                    }
                    if (o1 == 0) {
                        l[i] = '(';
                        o1++;
                        r[i] = ')';
                        o2--;
                    } else if (o2 == 0) {
                        l[i] = ')';
                        o1--;
                        r[i] = '(';
                        o2++;
                    } else {
                        if (o1 > o2) {
                            l[i] = ')';
                            o1--;
                            r[i] = '(';
                            o2++;
                        } else {
                            l[i] = '(';
                            o1++;
                            r[i] = ')';
                            o2--;
                        }
                    }
                } else {
                    if (o1 == 0 || o2 == 0) {
                        l[i] = '(';
                        o1++;
                        r[i] = '(';
                        o2++;
                    } else {
                        if (o1 > 1 || o2 > 1 || i == (n - 1) || w[i + 1] == '1') {
                            l[i] = ')';
                            o1--;
                            r[i] = ')';
                            o2--;
                        } else {
                            l[i] = '(';
                            o1++;
                            r[i] = '(';
                            o2++;
                        }
                    }
                }
            }
            if (o1 == 0 && o2 == 0) {
                System.out.println("YES");
                System.out.println(l);
                System.out.println(r);
            } else {
                System.out.println("NO");
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
