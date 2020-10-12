package atcoder.beginner_114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final Map<Integer, Integer> fact = new HashMap<>();
        for (int i = 2; i <= n; i++) {
            int limit = i;
            for (int p = 2; p * p <= i; p++) {
                while (limit % p == 0) {
                    fact.merge(p, 1, Integer::sum);
                    limit /= p;
                }
            }
            if (limit > 1) {
                fact.merge(limit, 1, Integer::sum);
            }
        }
        int greaterThan74 = 0;
        int greaterThan24 = 0;
        int greaterThan14 = 0;
        int greaterThan4 = 0;
        int greaterThan2 = 0;
        for (int val : fact.values()) {
            if (val >= 74) {
                greaterThan74++;
                greaterThan24++;
                greaterThan14++;
                greaterThan4++;
                greaterThan2++;
            } else if (val >= 24) {
                greaterThan24++;
                greaterThan14++;
                greaterThan4++;
                greaterThan2++;
            } else if (val >= 14) {
                greaterThan14++;
                greaterThan4++;
                greaterThan2++;
            } else if (val >= 4) {
                greaterThan4++;
                greaterThan2++;
            } else if (val >= 2) {
                greaterThan2++;
            }
        }
        int res = 0;
        res += greaterThan74;
        res += greaterThan24 * (greaterThan2 - 1);
        res += greaterThan14 * (greaterThan4 - 1);
        res += (greaterThan2 - 2) * (greaterThan4 * (greaterThan4 - 1) / 2);
        System.out.println(res);
    }

    private static void dfs(char[] curr, int idx, String n, int[] res, char[] nums) {
        if (idx == curr.length) {
            final String comp = new String(curr);
            if (comp.contains("3") && comp.contains("5") && comp.contains("7")
                && (idx < n.length() || comp.compareTo(n) <= 0)) {
                res[0]++;
            }
            return;
        }
        for (char num : nums) {
            curr[idx] = num;
            dfs(curr, idx + 1, n, res, nums);
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
