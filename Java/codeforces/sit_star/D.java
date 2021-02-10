package codeforces.sit_star;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        int a = fs.nextInt();
        int b = fs.nextInt();
        final char[] s = fs.next().toCharArray();
        final int[] large = new int[a * 2];
        final int[] small = new int[b];
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                if ((i + 1) < n && s[i + 1] == '0') {
                    if (a > 0) {
                        large[l++] = i + 1;
                        large[l++] = i + 2;
                        i++;
                        a--;
                    } else if (b > 0) {
                        small[r++] = i + 1;
                        b--;
                    }
                } else {
                    if (b > 0) {
                        small[r++] = i + 1;
                        b--;
                    }
                }
            }
        }
        if (a == 0 && b == 0) {
            System.out.println("YES");
            for (int i = 0; i < large.length; i += 2) {
                System.out.println(large[i] + " " + large[i + 1]);
            }
            for (int j : small) {
                System.out.println(j);
            }
        } else {
            System.out.println("NO");
        }
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
