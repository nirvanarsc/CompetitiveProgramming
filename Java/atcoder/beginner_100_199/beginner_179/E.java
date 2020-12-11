package atcoder.beginner_100_199.beginner_179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final long n = fs.nextLong();
        final long a = fs.nextLong();
        final long m = fs.nextLong();
        int meet = 0;
        long slow = a;
        long fast = a;
        do {
            slow = (slow * slow) % m;
            fast = (fast * fast) % m;
            fast = (fast * fast) % m;
        } while (slow != fast);
        slow = a;
        do {
            slow = (slow * slow) % m;
            fast = (fast * fast) % m;
            meet++;
        } while (slow != fast);
        long res = 0;
        long curr = a;
        for (int i = 0; i < Math.min(n, meet); i++) {
            res += curr;
            curr = (curr * curr) % m;
        }
        if (n <= meet) {
            System.out.println(res);
            return;
        }
        long cycleSum = 0;
        final long start = curr;
        int cycle = 0;
        do {
            cycleSum += curr;
            curr = (curr * curr) % m;
            cycle++;
        } while (start != curr);
        res += ((n - meet) / cycle) * cycleSum;
        for (int i = 0; i < (n - meet) % cycle; i++) {
            res += curr;
            curr = (curr * curr) % m;
        }
        System.out.println(res);
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
