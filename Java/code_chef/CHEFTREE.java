package code_chef;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public final class CHEFTREE {

    // https://www.codechef.com/problems/CHEFTREE
    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long[] maxSum;
        long operation;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                if (arr[leftMost] < limit) {
                    maxSum = new long[] { arr[leftMost], 0 };
                } else {
                    maxSum = new long[] { -inf, 1 };
                }
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                recalc();
            }
        }

        private void recalc() {
            maxSum = merge(left.maxSum, right.maxSum);
        }

        private static long[] merge(long[] l, long[] r) {
            return new long[] { Math.max(l[0], r[0]), l[1] + r[1] };
        }

        private void propagate() {
            left.operation += operation;
            right.operation += operation;
            left.maxSum[0] += operation;
            right.maxSum[0] += operation;
            operation = 0;
        }

        private long query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return maxSum[1];
            }
            propagate();
            recalc();
            return left.query(l, r) + right.query(l, r);
        }

        private void update(int l, int r, long add) {
            if (r < leftMost || l > rightMost || maxSum[0] == -inf) {
                return;
            }
            if (leftMost == rightMost) {
                maxSum[0] += add;
                if (maxSum[0] >= limit) {
                    maxSum[0] = -inf;
                    maxSum[1] = 1;
                }
                return;
            }
            if (l <= leftMost && rightMost <= r) {
                if (maxSum[0] + add < limit) {
                    maxSum[0] += add;
                    operation += add;
                    return;
                }
            }
            propagate();
            left.update(l, r, add);
            right.update(l, r, add);
            recalc();
        }
    }

    static long inf = (long) 1e18;
    static int n;
    static int q;
    static int h;
    static int labelTime;
    static int time;
    static long limit;
    static int[][] parents;
    static int[] arr;
    static int[][] edges;
    static int[][] g;
    static int[] parent;
    static int[] depth;
    static int[] size;
    static int[] heavy;
    static int[] label;
    static int[] topChain;
    static int[] in;
    static int[] out;
    static SegTree st;

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final StringBuilder sb = new StringBuilder();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            limit = 0;
            labelTime = 0;
            time = 0;
            h = 18;
            n = fs.nextInt();
            q = fs.nextInt();
            final long a = fs.nextInt();
            final long b = fs.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
            }
            edges = new int[n - 1][2];
            for (int i = 0; i < (n - 1); i++) {
                edges[i] = new int[] { fs.nextInt() - 1, fs.nextInt() - 1 };
            }
            g = packG();
            parent = new int[n];
            depth = new int[n];
            size = new int[n];
            heavy = new int[n];
            label = new int[n];
            topChain = new int[n];
            in = new int[n];
            out = new int[n];
            if (a != 0) {
                limit = -b / a;
                if (limit * a + b < 0) {
                    limit++;
                }
            } else {
                limit = b >= 0 ? -inf + 10 : inf;
            }
            dfs1(0, 0);
            initParents();
            dfs2(0, 0);
            final int[] stArr = new int[n];
            for (int i = 0; i < n; i++) {
                stArr[label[i]] = arr[i];
            }
            st = new SegTree(0, n - 1, stArr);
            for (int i = 0; i < q; i++) {
                final int type = fs.nextInt();
                if (type == 1) {
                    final int l = fs.nextInt() - 1;
                    final int r = fs.nextInt() - 1;
                    final int w = fs.nextInt();
                    final int lca = getLca(l, r);
                    updateChain(l, lca, w);
                    updateChain(r, lca, w);
                    st.update(label[lca], label[lca], w);
                } else {
                    final int l = fs.nextInt() - 1;
                    final int r = fs.nextInt() - 1;
                    final int lca = getLca(l, r);
                    final long res = queryChain(l, lca) + queryChain(r, lca) + st.query(label[lca], label[lca]);
                    sb.append(res);
                    sb.append('\n');
                }
            }
        }
        System.out.println(sb);
    }

    private static long queryChain(int u, int v) {
        long res = 0;
        while (depth[v] < depth[u]) {
            int top = topChain[u];
            if (depth[top] <= depth[v]) {
                final int diff = depth[u] - depth[v];
                top = getKthAncestor(u, diff - 1);
            }
            res += st.query(label[top], label[u]);
            u = parent[top];
        }
        return res;
    }

    private static void updateChain(int u, int v, int w) {
        while (depth[v] < depth[u]) {
            int top = topChain[u];
            if (depth[top] <= depth[v]) {
                final int diff = depth[u] - depth[v];
                top = getKthAncestor(u, diff - 1);
            }
            st.update(label[top], label[u], w);
            u = parent[top];
        }
    }

    private static void dfs1(int u, int v) {
        size[u] = 1;
        parent[u] = v;
        in[u] = time++;
        int max = g[u][0];
        for (int next : g[u]) {
            if (next != v) {
                depth[next] = depth[u] + 1;
                dfs1(next, u);
                size[u] += size[next];
                if (size[max] < size[next]) {
                    max = next;
                }
            }
        }
        out[u] = time;
        heavy[u] = max;
    }

    private static void dfs2(int u, int v) {
        label[u] = labelTime++;
        if (heavy[u] != v) {
            topChain[heavy[u]] = topChain[u];
            dfs2(heavy[u], u);
        }
        for (int next : g[u]) {
            if (next != v && next != heavy[u]) {
                topChain[next] = next;
                dfs2(next, u);
            }
        }
    }

    private static int[][] packG() {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
            ++size[edge[1]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = edge[1];
            g[edge[1]][--size[edge[1]]] = edge[0];
        }
        return g;
    }

    private static void initParents() {
        parents = new int[h + 1][n];
        parents[0] = parent;
        for (int i = 1; i < h; i++) {
            for (int u = 0; u < n; u++) {
                final int nodeParent = parents[i - 1][u];
                parents[i][u] = parents[i - 1][nodeParent];
            }
        }
    }

    private static int getKthAncestor(int u, int k) {
        for (int i = 0; i <= h; i++) {
            if ((k & (1 << i)) != 0) {
                u = parents[i][u];
            }
        }
        return u;
    }

    private static boolean isAncestor(int u, int v) {
        return in[u] <= in[v] && out[v] <= out[u];
    }

    private static int getLca(int u, int v) {
        if (isAncestor(u, v)) { return u; }
        if (isAncestor(v, u)) { return v; }
        for (int i = h; i >= 0; i--) {
            if (!isAncestor(parents[i][u], v)) {
                u = parents[i][u];
            }
        }
        return parents[0][u];
    }

    static final class Utils {
        private static class Shuffler {
            private static void shuffle(int[] x) {
                final Random r = new Random();

                for (int i = 0; i <= x.length - 2; i++) {
                    final int j = i + r.nextInt(x.length - i);
                    swap(x, i, j);
                }
            }

            private static void shuffle(long[] x) {
                final Random r = new Random();

                for (int i = 0; i <= x.length - 2; i++) {
                    final int j = i + r.nextInt(x.length - i);
                    swap(x, i, j);
                }
            }

            private static void swap(int[] x, int i, int j) {
                final int t = x[i];
                x[i] = x[j];
                x[j] = t;
            }

            private static void swap(long[] x, int i, int j) {
                final long t = x[i];
                x[i] = x[j];
                x[j] = t;
            }
        }

        public static void shuffleSort(int[] arr) {
            Shuffler.shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffleSort(long[] arr) {
            Shuffler.shuffle(arr);
            Arrays.sort(arr);
        }

        private static int[][] packG(int[][] edges, int n) {
            final int[][] g = new int[n][];
            final int[] size = new int[n];
            for (int[] edge : edges) {
                ++size[edge[0]];
            }
            for (int i = 0; i < n; i++) {
                g[i] = new int[size[i]];
            }
            for (int[] edge : edges) {
                g[edge[0]][--size[edge[0]]] = edge[1];
            }
            return g;
        }

        private static int[][][] packGW(int[][] edges, int n) {
            final int[][][] g = new int[n][][];
            final int[] size = new int[n];
            for (int[] edge : edges) {
                ++size[edge[0]];
            }
            for (int i = 0; i < n; i++) {
                g[i] = new int[size[i]][2];
            }
            for (int[] edge : edges) {
                g[edge[0]][--size[edge[0]]] = new int[] { edge[1], edge[2] };
            }
            return g;
        }

        private Utils() {}
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
