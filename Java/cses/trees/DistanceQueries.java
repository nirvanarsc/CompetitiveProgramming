package cses.trees;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public final class DistanceQueries {

    static int n;
    static int q;
    static int h;
    static int time;
    static int[][] parents;
    static int[][] edges;
    static int[][] g;
    static int[] parent;
    static int[] depth;
    static int[] in;
    static int[] out;

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        n = fs.nextInt();
        q = fs.nextInt();
        h = 18;
        edges = new int[n - 1][2];
        for (int i = 0; i < (n - 1); i++) {
            edges[i] = new int[] { fs.nextInt() - 1, fs.nextInt() - 1 };
        }
        g = packG();
        parent = new int[n];
        depth = new int[n];
        in = new int[n];
        out = new int[n];
        dfs1();
        dfs2();
        initParents();
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            final int lca = getLca(u, v);
            final int res = depth[u] + depth[v] - 2 * depth[lca];
            sb.append(res);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs1() {
        final int[] stack = new int[n];
        int stackIdx = 0;
        stack[stackIdx++] = 0;
        parent[0] = 0;
        depth[0] = 0;
        while (stackIdx > 0) {
            final int u = stack[--stackIdx];
            depth[u] = depth[parent[u]] + 1;
            for (int v : g[u]) {
                if (v != parent[u]) {
                    parent[v] = u;
                    stack[stackIdx++] = v;
                }
            }
        }
    }

    private static void dfs2() {
        final int[] stack = new int[n];
        final int[] idx = new int[n];
        int stackIdx = 0;
        stack[stackIdx++] = 0;
        while (stackIdx > 0) {
            final int u = stack[stackIdx - 1];
            if (idx[u] == 0) {
                in[u] = time++;
            }
            if (idx[u] < g[u].length) {
                final int v = g[u][idx[u]++];
                if (parent[u] != v) {
                    stack[stackIdx++] = v;
                }
            } else {
                out[u] = time;
                stackIdx--;
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
