package cses.trees;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public final class PathQueriesII {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int max;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                max = arr[leftMost];
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                recalc();
            }
        }

        private void recalc() {
            max = Math.max(left.max, right.max);
        }

        private int query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return (int) -1e9;
            }
            if (l <= leftMost && rightMost <= r) {
                return max;
            }
            return Math.max(left.query(l, r), right.query(l, r));
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                max = val;
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
    }

    static int n;
    static int q;
    static int h;
    static int labelTime;
    static int time;
    static int[][] parents;
    static int[][] edges;
    static int[][] g;
    static int[] arr;
    static int[] heavy;
    static int[] size;
    static int[] parent;
    static int[] depth;
    static int[] label;
    static int[] topChain;
    static int[] in;
    static int[] out;
    static SegTree st;

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        n = fs.nextInt();
        q = fs.nextInt();
        h = 18;
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
        st = new SegTree(0, n - 1, new int[n]);
        dfs1();
        initParents();
        dfs2();
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            final int type = fs.nextInt();
            if (type == 1) {
                final int idx = fs.nextInt() - 1;
                final int v = fs.nextInt();
                st.update(label[idx], v);
                arr[idx] = v;
            } else {
                final int l = fs.nextInt() - 1;
                final int r = fs.nextInt() - 1;
                final int lca = getLca(l, r);
                final long res = Math.max(queryChain(l, lca), queryChain(r, lca));
                sb.append(Math.max(res, arr[lca]));
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    private static long queryChain(int u, int v) {
        long val = (long) -1e9;
        while (depth[v] < depth[u]) {
            int top = topChain[u];
            if (depth[top] <= depth[v]) {
                final int diff = depth[u] - depth[v];
                top = getKthAncestor(u, diff - 1);
            }
            val = Math.max(val, st.query(label[top], label[u]));
            u = parent[top];
        }
        return val;
    }

    private static void dfs1() {
        final int[] stack = new int[n];
        final int[] idx = new int[n];
        int stackIdx = 0;
        stack[stackIdx++] = 0;
        while (stackIdx > 0) {
            final int u = stack[stackIdx - 1];
            final int v = parent[u];
            if (idx[u] == 0) {
                in[u] = time++;
                size[u] = 1;
                depth[u] = depth[parent[u]] + 1;
                heavy[u] = g[u][0];
            }
            if (idx[u] < g[u].length) {
                final int next = g[u][idx[u]++];
                if (next != v) {
                    parent[next] = u;
                    stack[stackIdx++] = next;
                }
            } else {
                stackIdx--;
                size[v] += size[u];
                out[u] = time++;
                if (size[heavy[v]] < size[u]) {
                    heavy[v] = u;
                }
            }
        }
    }

    private static void dfs2() {
        final int[] stack = new int[n];
        int stackIdx = 0;
        stack[stackIdx++] = 0;
        while (stackIdx > 0) {
            final int u = stack[--stackIdx];
            label[u] = labelTime++;
            st.update(label[u], arr[u]);
            for (int v : g[u]) {
                if (v != parent[u] && v != heavy[u]) {
                    topChain[v] = v;
                    stack[stackIdx++] = v;
                }
            }
            if (heavy[u] != parent[u]) {
                topChain[heavy[u]] = topChain[u];
                stack[stackIdx++] = heavy[u];
            }
        }
    }

//    private static void dfs1(int u, int v) {
//        size[u] = 1;
//        parent[u] = v;
//        in[u] = time++;
//        int max = g[u][0];
//        for (int next : g[u]) {
//            if (next != v) {
//                depth[next] = depth[u] + 1;
//                dfs1(next, u);
//                size[u] += size[next];
//                if (size[max] < size[next]) {
//                    max = next;
//                }
//            }
//        }
//        out[u] = time;
//        heavy[u] = max;
//    }
//
//    private static void dfs2(int u, int v) {
//        label[u] = labelTime++;
//        st.update(label[u], arr[u]);
//        if (heavy[u] != v) {
//            topChain[heavy[u]] = topChain[u];
//            dfs2(heavy[u], u);
//        }
//        for (int next : g[u]) {
//            if (next != v && next != heavy[u]) {
//                topChain[next] = next;
//                dfs2(next, u);
//            }
//        }
//    }

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
