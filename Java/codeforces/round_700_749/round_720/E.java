package codeforces.round_700_749.round_720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public int superpalindromesInRange(String left, String right) {
        return f(right) - f(String.valueOf(Long.valueOf(left) - 1));
    }

    private static int f(String n) {
        int[] res = { 0 };
        dfs("", n, res);
        return res[0];
    }

    private static void dfs(String curr, String n, int[] res) {
//        System.out.println(curr);
        if (curr.length() > n.length() || curr.length() == n.length() && curr.compareTo(n) > 0) {
            return;
        }
        if (isValid(curr)) {
            res[0]++;
        }
        for (int i = 0; i < 10; i++) {
            if (curr.isEmpty()) {
                dfs(String.valueOf(i), n, res);
            }
            dfs(i + curr + i, n, res);
        }
    }

    private static boolean isValid(String n) {
        if (n.isEmpty()) {
            return false;
        }
        final long num = Long.valueOf(n);
        if (num == 0) {
            return false;
        }
        final long sqrt = (long) Math.sqrt(num);
        if (sqrt * sqrt != num) {
            return false;
        }
        return isPalindrome(String.valueOf(sqrt));
    }

    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        final FastScanner fs = new FastScanner();
//        final int t = fs.nextInt();
//        for (int test = 0; test < t; test++) {
//            final int n = fs.nextInt();
//            System.out.println(n);
//        }
        System.out.println(new E().superpalindromesInRange("40000",
                                                           "50000"));
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
