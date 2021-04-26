package gcj.year_2019.round1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    // 5 x 7 x 9 x 11 x 13 x 16 x 17 = 12252240
    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int[] nums = { 5, 7, 9, 11, 13, 16, 17 };
        for (int test = 1; test <= t; test++) {
            final int[] mod = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                final StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 18; j++) {
                    sb.append(nums[i]);
                    sb.append(' ');
                }
                System.out.println(sb);
                for (int j = 0; j < 18; j++) {
                    mod[i] = (mod[i] + fs.nextInt()) % nums[i];
                }
            }
            for (int num = 1; num <= 1e6; num++) {
                boolean ok = true;
                for (int j = 0; j < nums.length; j++) {
                    if (num % nums[j] != mod[j]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    System.out.println(num);
                    final int res = fs.nextInt();
                    if (res != 1) {
                        System.exit(1);
                    }
                    break;
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
