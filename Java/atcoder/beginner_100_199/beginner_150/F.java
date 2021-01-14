package atcoder.beginner_100_199.beginner_150;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[] a = fs.nextIntArray(n);
        final int[] b = fs.nextIntArray(n);
        final int[] fa = f(a, n);
        final int[] fb = f(b, n);
        final int[] resizeB = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            resizeB[i] = fb[i % n];
        }
        final List<Integer> shift = findAll(resizeB, fa);
        final List<Integer> rotated = new ArrayList<>();
        for (int k : shift) {
            rotated.add(n - k);
        }
        rotated.sort(Comparator.naturalOrder());
        for (int k : rotated) {
            if (k < n) {
                System.out.println(k + " " + (a[k] ^ b[0]));
            }
        }
    }

    private static int[] f(int[] arr, int n) {
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = arr[i] ^ arr[(i + 1) % n];
        }
        return res;
    }

    // KMP
    private static List<Integer> findAll(int[] haystack, int[] needle) {
        final int[] prefixSuffix = kmp(needle);
        final List<Integer> res = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < haystack.length; i++) {
            while (j != -1 && haystack[i] != needle[j]) {
                j = prefixSuffix[j];
            }
            if (++j == needle.length) {
                res.add(i - j + 1);
                j = prefixSuffix[j];
            }
        }
        return res;
    }

    private static int[] kmp(int[] s) {
        final int n = s.length;
        final int[] prefixSuffix = new int[n + 1];
        prefixSuffix[0] = -1;
        int j = -1;
        for (int i = 0; i < n; i++) {
            while (j != -1 && s[i] != s[j]) {
                j = prefixSuffix[j];
            }
            prefixSuffix[i + 1] = ++j;
        }
        return prefixSuffix;
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
