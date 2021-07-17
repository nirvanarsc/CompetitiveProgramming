package atcoder.beginner_200_299.abc_210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class A {

    static int prev;
    static int target;

    public int[] threeEqualParts(int[] arr) {
        int sum = 0;
        final int n = arr.length;
        for (int j : arr) {
            sum += j;
        }
        if (sum % 3 != 0) {
            return new int[] { -1, -1 };
        }
        prev = 0;
        target = sum / 3;
        final int[] res = new int[2];
        final StringBuilder s1 = f(arr, n);
        res[0] = prev - 1;
        final StringBuilder s2 = f(arr, n);
        res[1] = prev - 1;
        final StringBuilder s3 = f(arr, n);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        if (s1.toString().equals(s2.toString()) && s2.toString().equals(s3.toString())) {
            return res;
        }
        return new int[] { -1, -1 };
    }

    private static StringBuilder f(int[] arr, int n) {
        final StringBuilder s1 = new StringBuilder();
        int count = 0;
        for (int i = prev; i < n; i++) {
            s1.append(arr[i]);
            count += arr[i];
            if (count == target) {
                prev = i + 1;
                break;
            }
        }
        s1.reverse();
        while (s1.charAt(s1.length() - 1) == '0') {
            s1.deleteCharAt(s1.length() - 1);
        }
        s1.reverse();
        return s1;
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int a = fs.nextInt();
        final int x = fs.nextInt();
        final int y = fs.nextInt();

        final int ll = Math.min(n, a);
        final int rr = Math.max(0, n - ll);

        System.out.println(ll * x + rr * y);
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
