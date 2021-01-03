package atcoder.beginner_100_199.beginner_187;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long sum;
        long operation;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                sum = arr[leftMost];
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                recalc();
            }
        }

        private void recalc() {
            if (leftMost == rightMost) {
                return;
            }
            sum = left.sum + right.sum;
        }

        private void propagate() {
            if (leftMost == rightMost) {
                return;
            }
            left.operation += operation;
            right.operation += operation;
            left.sum += (left.rightMost - left.leftMost + 1) * operation;
            right.sum += (right.rightMost - right.leftMost + 1) * operation;
            operation = 0;
        }

        private long query(int l, int r) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return sum;
            }
            return left.query(l, r) + right.query(l, r);
        }

        private void add(int l, int r, long v) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return;
            }
            if (l <= leftMost && rightMost <= r) {
                sum += (rightMost - leftMost + 1) * v;
                operation += v;
                return;
            }
            left.add(l, r, v);
            right.add(l, r, v);
            sum = left.sum + right.sum;
        }
    }

    public static void main(String[] args) {
        final PrintWriter pw = new PrintWriter(System.out);
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[][] edges = new int[n - 1][2];
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            final int u = fs.nextInt();
            final int v = fs.nextInt();
            edges[i] = new int[] { u, v };
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }
        final List<Integer> euler = new ArrayList<>(2 * n);
        final int[][] ranges = new int[n][2];
        final int[] depths = new int[n];
        for (int i = 0; i < n; i++) {
            ranges[i] = new int[] { (int) 1e9, -(int) 1e9 };
        }
        dfs(1, -1, g, euler, depths, 0);
        for (int i = 0; i < euler.size(); i++) {
            final int edge = euler.get(i);
            ranges[edge - 1][0] = Math.min(ranges[edge - 1][0], i);
            ranges[edge - 1][1] = Math.max(ranges[edge - 1][1], i);
        }
        final SegTree st = new SegTree(0, 2 * n - 1, new int[2 * n]);
        final int q = fs.nextInt();
        for (int i = 0; i < q; i++) {
            final int type = fs.nextInt();
            final int e = fs.nextInt();
            final int c = fs.nextInt();
            int l = edges[e - 1][0] - 1;
            int r = edges[e - 1][1] - 1;
            if (type == 2) {
                final int temp = l;
                l = r;
                r = temp;
            }
            final int inL = ranges[l][0];
            final int outL = ranges[l][1];
            final int inR = ranges[r][0];
            final int outR = ranges[r][1];
            if (depths[l] > depths[r]) {
                st.add(inL, outL, c);
            } else {
                st.add(0, 2 * n - 1, c);
                st.add(inR, outR, -c);
            }
        }
        for (int[] range : ranges) {
            pw.println(st.query(range[0], range[0]));
        }
        pw.close();
    }

    private static void dfs(int u, int v, Map<Integer, List<Integer>> g,
                            List<Integer> euler, int[] depths, int d) {
        euler.add(u);
        depths[u - 1] = d;
        for (int next : g.getOrDefault(u, Collections.emptyList())) {
            if (next != v) {
                dfs(next, u, g, euler, depths, d + 1);
            }
        }
        euler.add(u);
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
