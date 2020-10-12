package atcoder.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class J {

    private static class Node {
        int[] freq = new int[3];
        int[] prefixSum = new int[3];
        long count;
    }

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        Node node = new Node();

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                node.freq[arr[leftMost]]++;
                for (int i = arr[leftMost]; i <= 2; i++) {
                    node.prefixSum[i]++;
                }
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                node = merge(left.node, right.node);
            }
        }

        private static Node merge(Node l, Node r) {
            final Node res = new Node();
            for (int i = 1; i <= 2; i++) {
                res.freq[i] = l.freq[i] + r.freq[i];
                res.prefixSum[i] = res.freq[i] + res.prefixSum[i - 1];
                res.count += (long) l.freq[i] * r.prefixSum[i - 1];
            }
            res.count += l.count + r.count;
            return res;
        }

        private Node query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return new Node();
            }
            if (l <= leftMost && rightMost <= r) {
                return node;
            }
            return merge(left.query(l, r), right.query(l, r));
        }

        private void update(int idx, int newVal) {
            if (leftMost == rightMost) {
                node = new Node();
                node.freq[newVal]++;
                for (int i = newVal; i <= 2; i++) {
                    node.prefixSum[i]++;
                }
            } else {
                final int mid = leftMost + rightMost >>> 1;
                if (idx <= mid) {
                    left.update(idx, newVal);
                } else {
                    right.update(idx, newVal);
                }
                node = merge(left.node, right.node);
            }
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt() + 1;
        }
        SegTree st = new SegTree(0, n - 1, arr);
        for (int i = 0; i < q; i++) {
            int type = fs.nextInt();
            if (type == 1) {

            } else {
                System.out.println(st.query(fs.nextInt() - 1, fs.nextInt() - 1).count);
            }
        }
        System.out.println(n);
    }

    static final class Util {
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

        private Util() {}
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
