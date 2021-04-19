package kickstart.year_2021.round_b;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class D {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long gcd;

        SegTree(int leftMost, int rightMost, long[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                gcd = arr[leftMost];
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                recalc();
            }
        }

        private void recalc() {
            gcd = gcd(left.gcd, right.gcd);
        }

        private long query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return gcd;
            }
            return gcd(left.query(l, r), right.query(l, r));
        }

        private void update(int idx, long val) {
            if (leftMost == rightMost) {
                gcd = val;
            } else {
                final int mid = leftMost + rightMost >>> 1;
                if (idx <= mid) {
                    left.update(idx, val);
                } else {
                    right.update(idx, val);
                }
                recalc();
            }
        }

        private static long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }

    static int n;
    static int q;
    static List<List<int[]>> queries;
    static long[][] edges;
    static long[][][] g;
    static long[] res;
    static SegTree st;

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int test = fs.nextInt();
        for (int t = 1; t <= test; t++) {
            n = fs.nextInt();
            q = fs.nextInt();
            edges = new long[n - 1][4];
            for (int i = 0; i < (n - 1); i++) {
                final int u = fs.nextInt() - 1;
                final int v = fs.nextInt() - 1;
                final int l = fs.nextInt();
                final long c = fs.nextLong();
                edges[i] = new long[] { u, v, l, c };
            }
            g = packG();
            queries = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                queries.add(new ArrayList<>());
            }
            for (int i = 0; i < q; i++) {
                final int u = fs.nextInt() - 1;
                queries.get(u).add(new int[] { fs.nextInt(), i });
            }
            res = new long[q];
            st = new SegTree(0, (int) 2e5 + 4, new long[(int) 2e5 + 5]);
            dfs(0, -1);
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < q; i++) {
                sb.append(res[i]);
                sb.append(' ');
            }
            System.out.println("Case #" + t + ": " + sb);
        }
    }

    private static void dfs(int u, int v) {
        for (int[] qq : queries.get(u)) {
            res[qq[1]] = st.query(0, qq[0]);
        }
        for (long[] next : g[u]) {
            final int n = (int) next[0];
            if (n != v) {
                final int point = (int) next[1];
                final long val = next[2];
                st.update(point, val);
                dfs(n, u);
                st.update(point, 0);
            }
        }
    }

    private static long[][][] packG() {
        final long[][][] g = new long[n][][];
        final int[] size = new int[n];
        for (long[] edge : edges) {
            ++size[(int) edge[0]];
            ++size[(int) edge[1]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new long[size[i]][];
        }
        for (long[] edge : edges) {
            g[(int) edge[0]][--size[(int) edge[0]]] = new long[] { edge[1], edge[2], edge[3] };
            g[(int) edge[1]][--size[(int) edge[1]]] = new long[] { edge[0], edge[2], edge[3] };
        }
        return g;
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

        FastReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            final byte[] buf = new byte[1024]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextSign() throws IOException {
            byte c = read();
            while ('+' != c && '-' != c) {
                c = read();
            }
            return '+' == c ? 0 : 1;
        }

        private static boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }

        private int skip() throws IOException {
            int b;
            //noinspection StatementWithEmptyBody
            while ((b = read()) != -1 && isSpaceChar(b)) {}
            return b;
        }

        public char nc() throws IOException {
            return (char) skip();
        }

        public String next() throws IOException {
            int b = skip();
            final StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = read();
            }
            return sb.toString();
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

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') { c = read(); }
            final boolean neg = c == '-';
            if (neg) { c = read(); }
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg) { return -ret; }
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') { c = read(); }
            final boolean neg = c == '-';
            if (neg) { c = read(); }

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

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
