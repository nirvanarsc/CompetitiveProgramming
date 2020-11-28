package codeforces.round_650_699.round_686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    private static class SegTreeMin {
        int leftMost, rightMost;
        SegTreeMin left, right;
        int min;

        SegTreeMin(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                min = arr[leftMost];
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTreeMin(leftMost, mid, arr);
                right = new SegTreeMin(mid + 1, rightMost, arr);
                recalc();
            }
        }

        private void recalc() {
            if (leftMost == rightMost) {
                return;
            }
            min = Math.min(left.min, right.min);
        }

        private int query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return Integer.MAX_VALUE;
            }
            if (l <= leftMost && rightMost <= r) {
                return min;
            }
            return Math.min(left.query(l, r), right.query(l, r));
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        outer:
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            final SegTreeMin stMin = new SegTreeMin(0, n - 1, arr);
            final int[] preMax = new int[n];
            final int[] suffMax = new int[n];
            final Map<Integer, Integer> first = new HashMap<>();
            final Map<Integer, Integer> last = new HashMap<>();
            int currMax = 0;
            for (int i = 0; i < n; i++) {
                currMax = Math.max(currMax, arr[i]);
                preMax[i] = currMax;
            }
            currMax = 0;
            for (int i = n - 1; i >= 0; i--) {
                currMax = Math.max(currMax, arr[i]);
                suffMax[i] = currMax;
            }
            for (int i = 0; i < n; i++) {
                last.put(suffMax[i], i);
            }
            for (int i = n - 1; i >= 0; i--) {
                first.put(suffMax[i], i);
            }
            for (int l = 0; l < n - 2; l++) {
                final int val = preMax[l];
                int lo = Math.max(l + 2, first.getOrDefault(val, n));
                int hi = last.getOrDefault(val, 0);
                while (lo <= hi) {
                    final int mid = lo + hi >>> 1;
                    final int rmq = stMin.query(l + 1, mid - 1);
                    if (rmq > val) {
                        lo = mid + 1;
                    } else if (rmq < val) {
                        hi = mid - 1;
                    } else {
                        System.out.println("YES");
                        System.out.println((l + 1) + " " + (mid - (l + 1)) + ' ' + (n - mid));
                        continue outer;
                    }
                }
            }
            System.out.println("NO");
        }
    }

    static final class Utils {
        public static void shuffleSort(int[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffleSort(long[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffle(int[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void shuffle(long[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void swap(int[] x, int i, int j) {
            final int t = x[i];
            x[i] = x[j];
            x[j] = t;
        }

        public static void swap(long[] x, int i, int j) {
            final long t = x[i];
            x[i] = x[j];
            x[j] = t;
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
