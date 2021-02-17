package codeforces.round_700_749.round_702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        int arrIdx;

        TreeNode(int val, int arrIdx) {
            this.val = val;
            this.arrIdx = arrIdx;
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            final int[] res = new int[n];
            dfs2(dfs(arr, 0, n - 1), res, 0);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }

    @SuppressWarnings({ "ReturnOfNull", "ConstantConditions" })
    private static TreeNode dfs(int[] arr, int l, int r) {
        if (l > r) {
            return null;
        }
        int max = -1;
        int maxVal = -1;
        for (int i = l; i <= r; i++) {
            if (maxVal < arr[i]) {
                maxVal = arr[i];
                max = i;
            }
        }
        final TreeNode root = new TreeNode(maxVal, max);
        root.left = dfs(arr, l, max - 1);
        root.right = dfs(arr, max + 1, r);
        return root;
    }

    private static void dfs2(TreeNode node, int[] res, int d) {
        if (node == null) {
            return;
        }
        res[node.arrIdx] = d;
        dfs2(node.left, res, d + 1);
        dfs2(node.right, res, d + 1);
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
