package atcoder.regular_110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final String s = fs.next();
        final char[] chars = s.toCharArray();
        final long res = (long) 1e10;
        final int first = s.indexOf("110");
        final int last = s.lastIndexOf("110");
        boolean valid = true;
        int count = 0;
        if (first != -1) {
            for (int i = first; i <= last; i += 3) {
                final char c1 = chars[i];
                final char c2 = chars[i + 1];
                final char c3 = chars[i + 2];
                if (c1 != '1' || c2 != '1' || c3 != '0') {
                    valid = false;
                    break;
                }
                count++;
            }
            if (first > 0 && last + 3 < n) {
                final String ll = s.substring(0, first);
                final String rr = s.substring(last + 3);
                valid &= "110".contains(ll);
                valid &= "110".contains(rr);
                if (valid) {
                    System.out.println(res - count - 1);
                } else {
                    System.out.println(0);
                }
            } else if (first > 0) {
                final String ll = s.substring(0, first);
                valid &= "110".contains(ll);
                if (valid) {
                    System.out.println(res - count);
                } else {
                    System.out.println(0);
                }
            } else if (last + 3 < n) {
                final String rr = s.substring(last + 3);
                valid &= "110".contains(rr);
                if (valid) {
                    System.out.println(res - count);
                } else {
                    System.out.println(0);
                }
            } else {
                if (valid) {
                    System.out.println(res - count + 1);
                } else {
                    System.out.println(0);
                }
            }
        } else {
            if ("1".equals(s)) {
                System.out.println(2 * res);
            } else if ("0".equals(s)) {
                System.out.println(res);
            } else if (n > 4) {
                System.out.println(0);
            } else if ("110".contains(s)) {
                System.out.println(res);
            } else if ("110110".contains(s)) {
                System.out.println(res - 1);
            } else {
                System.out.println(0);
            }
        }
    }

    static final class Utils {
        public static void shuffleSort(int[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffleSort(long[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffle(int[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void shuffle(long[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void swap(int[] arr, int i, int j) {
            final int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

        public static void swap(long[] arr, int i, int j) {
            final long t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
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
