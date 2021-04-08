package spoj.classical;

import java.io.DataInputStream;
import java.io.IOException;

public final class GSS1 {

    private static class Node {
        long prefix, suffix, sum, best;

        Node(long prefix, long suffix, long sum, long best) {
            this.prefix = prefix;
            this.suffix = suffix;
            this.sum = sum;
            this.best = best;
        }
    }

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        Node node = nullValue();

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                node = new Node(arr[leftMost], arr[leftMost], arr[leftMost], arr[leftMost]);
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                recalc();
            }
        }

        private void recalc() {
            node = merge(left.node, right.node);
        }

        private static Node nullValue() {
            return new Node(-15007, -15007, 0, -15007);
        }

        private static Node merge(Node left, Node right) {
            final long newPre = Math.max(left.prefix, left.sum + right.prefix);
            final long newSuff = Math.max(right.suffix, right.sum + left.suffix);
            final long newSum = left.sum + right.sum;
            final long newBest = Math.max(Math.max(left.best, right.best), left.suffix + right.prefix);
            return new Node(newPre, newSuff, newSum, newBest);
        }

        private Node query(int l, int r) {
            if (r < leftMost || l > rightMost) { return nullValue(); }
            if (l <= leftMost && rightMost <= r) { return node; }
            return merge(left.query(l, r), right.query(l, r));
        }
    }

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int n = fs.nextInt();
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }
        final SegTree st = new SegTree(0, n - 1, arr);
        final int q = fs.nextInt();
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            final int l = fs.nextInt() - 1;
            final int r = fs.nextInt() - 1;
            sb.append(st.query(l, r).best);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static class FastReader {
        private static final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            final boolean neg = c == '-';
            if (neg) { c = read(); }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) { return -ret; }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) { buffer[0] = -1; }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) { fillBuffer(); }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            din.close();
        }
    }
}
