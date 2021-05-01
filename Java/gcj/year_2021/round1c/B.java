package gcj.year_2021.round1c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 1; test <= t; test++) {
            final String n = fs.next();
            final int L = n.length();
            String res = null;
            for (int i = 1; i <= (L + 1) / 2; i++) {
                int parseInt = Integer.parseInt(n.substring(0, i));
                int ten = 1;
                for (int j = 1; j < i; j++) {
                    ten *= 10;
                }
                final List<Integer> tests = new ArrayList<>();
                for (int j = 0; j < 10; j++) {
                    tests.add(parseInt++);
                }
                for (int j = 0; j < 10; j++) {
                    if (ten - j >= 1) {
                        tests.add(ten - j);
                    }
                    tests.add(ten + j);
                }
                for (int num : tests) {
                    final StringBuilder sb = new StringBuilder();
                    int start = num;
                    while (sb.length() < L || sb.length() == L && sb.toString().compareTo(n) <= 0) {
                        sb.append(start);
                        start++;
                    }
                    if (res == null || sb.length() < res.length()
                        || sb.length() == res.length() && sb.toString().compareTo(res) < 0) {
                        res = sb.toString();
                    }
                }
            }
            System.out.println("Case #" + test + ": " + (L == 1 ? "12" : res));
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
