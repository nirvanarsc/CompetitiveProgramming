package atcoder.beginner_100_199.beginner_188;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final long x = fs.nextLong();
        final long y = fs.nextLong();
        final Map<Long, Long> map = new HashMap<>();
        final Deque<Long> q = new ArrayDeque<>();
        map.put(y, 0L);
        q.offerLast(y);
        while (!q.isEmpty()) {
            final long curr = q.removeFirst();
            final long c = map.get(curr);
            if (curr == 1) {
                continue;
            }
            if (curr % 2 != 0) {
                if (!map.containsKey(curr + 1)) {
                    map.put(curr + 1, c + 1);
                    q.offerLast(curr + 1);
                }
                if (!map.containsKey(curr - 1)) {
                    map.put(curr - 1, c + 1);
                    q.offerLast(curr - 1);
                }
            } else {
                if (!map.containsKey(curr / 2)) {
                    map.put(curr / 2, c + 1);
                    q.offerLast(curr / 2);
                }
            }

        }
        long res = (long) 9e18;
        for (Map.Entry<Long, Long> e : map.entrySet()) {
            res = Math.min(res, Math.abs(x - e.getKey()) + e.getValue());
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
