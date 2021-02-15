package atcoder.beginner_100_199.beginner_168;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        long res = modPow(2, n);
        int zero = 0;
        final Map<String, Integer> map1 = new HashMap<>();
        final Map<String, Integer> map2 = new HashMap<>();
        final long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            long x = fs.nextLong();
            long y = fs.nextLong();
            if (x == 0 && y == 0) {
                zero++;
                continue;
            }
            final long gcd = gcd(x, y);
            x /= gcd;
            y /= gcd;
            if (y < 0) {
                x = -x;
                y = -y;
            }
            if (y == 0 && x < 0) {
                x = -x;
            }
            final boolean rot90 = x <= 0;
            if (rot90) {
                final long temp = x;
                x = y;
                y = -temp;
            }
            if (rot90) {
                map1.merge(x + "," + y, 1, Integer::sum);
            } else {
                map2.merge(x + "," + y, 1, Integer::sum);
            }
            arr[i] = new long[] { x, y };
        }
        for (int i = 0; i < n; i++) {
            final int l = map1.getOrDefault(arr[i][0] + "," + arr[i][1], 0);
            final int r = map2.getOrDefault(arr[i][0] + "," + arr[i][1], 0);
            final long ll = modPow(l, 2);
            final long rr = modPow(r, 2);
            final long add = (ll + rr - 1) % MOD;
            res = Math.floorMod(res - add, MOD);
        }
//        for (Map.Entry<String, Integer> e : map2.entrySet()) {
//            int l = map1.getOrDefault(e.getKey(), 0);
//            int r = e.getValue();
//            long ll = modPow(l, 2);
//            long rr = modPow(r, 2);
//            long add = (ll + rr - 1) % MOD;
//            res = Math.floorMod(res - add, MOD);
//        }
        res = (res + zero) % MOD;
        System.out.println(res);
    }

    private static long modPow(long a, long n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            n /= 2;
        }
        return res;
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
