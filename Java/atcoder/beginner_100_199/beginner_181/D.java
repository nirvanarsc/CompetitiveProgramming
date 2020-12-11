package atcoder.beginner_100_199.beginner_181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final String s = fs.next();
        System.out.println(solve(s, s.length()) ? "Yes" : "No");
    }

    public static boolean solve(String str, int n) {
        if (n < 3) {
            if (Integer.parseInt(str) % 8 == 0) {
                return true;
            }
            str = new String(new StringBuilder().append(str).reverse());

            return Integer.parseInt(str) % 8 == 0;
        }
        final int[] hash = new int[10];
        for (int i = 0; i < n; i++) {
            hash[str.charAt(i) - '0']++;
        }
        if (hash[0] >= 3) {
            return true;
        }
        for (int curr = 104; curr < 1000; curr += 8) {
            int dup = curr;
            final int[] freq = new int[10];
            final int a = dup % 10;
            dup /= 10;
            final int b = dup % 10;
            dup /= 10;
            final int c = dup % 10;
            freq[a]++;
            freq[b]++;
            freq[c]++;
            if (hash[a] >= freq[a] && hash[b] >= freq[b] && hash[c] >= freq[c]) {
                return true;
            }
        }
        return false;
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
