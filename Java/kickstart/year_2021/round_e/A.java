package kickstart.year_2021.round_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class A {

    // https://codeforces.com/blog/entry/66176
    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        outer:
        for (int x = 1; x <= t; x++) {
            final char[] w = fs.next().toCharArray();
            final int len = w.length;
            final List<int[]> sorted = new ArrayList<>();
            final List<int[]> rotated = new ArrayList<>();
            final int[] f = new int[26];
            for (int i = 0; i < len; i++) {
                f[w[i] - 'a']++;
                sorted.add(new int[] { i, w[i] - 'a' });
                rotated.add(new int[] { i, w[i] - 'a' });
            }
            int max = 0;
            for (int i = 0; i < 26; i++) {
                if (f[i] > len / 2) {
                    System.out.println("Case #" + x + ": IMPOSSIBLE");
                    continue outer;
                }
                max = Math.max(max, f[i]);
            }
            sorted.sort(Comparator.comparingInt(a -> a[1]));
            rotated.sort(Comparator.comparingInt(a -> a[1]));
            Collections.rotate(rotated, max);
            final char[] res = new char[len];
            for (int i = 0; i < len; i++) {
                res[sorted.get(i)[0]] = (char) (rotated.get(i)[1] + 'a');
            }
            System.out.println("Case #" + x + ": " + new String(res));
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
