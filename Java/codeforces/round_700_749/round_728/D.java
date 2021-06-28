package codeforces.round_700_749.round_728;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public final class D {

    private static final int MOD = (int) (1e9 + 7);

    static int n;
    static int h = 10;
    static int time;
    static int[][] parents;
    static int[][] edges;
    static int[][] g;
    static int[] d;
    static int[] parent;
    static int[] in;
    static int[] out;
    static long[][] dp;
    static boolean[][] seen;
    static long inv2;

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        n = fs.nextInt();
        edges = new int[n - 1][2];
        for (int i = 0; i < (n - 1); i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            edges[i] = new int[] { u, v };
        }
        g = packG();
        inv2 = modPow(2, MOD - 2);
        long res = 0;
        for (int i = 0; i < n; i++) {
            time = 0;
            in = new int[n];
            out = new int[n];
            d = new int[n];
            parent = new int[n];
            dfs(i, i);
            initParents();
            dp = new long[n][n];
            seen = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    final int lca = getLca(j, k);
                    final int u = d[j] - d[lca];
                    final int v = d[k] - d[lca];
                    res = (res + dfs2(u, v)) % MOD;
                }
            }
        }
        System.out.println((res * modPow(n, MOD - 2)) % MOD);
    }

    private static long dfs2(int l, int r) {
        if (l == 0) {
            return 0;
        }
        if (r == 0) {
            return 1;
        }
        if (seen[l][r]) {
            return dp[l][r];
        }
        long res = (dfs2(l - 1, r) + dfs2(l, r - 1)) % MOD;
        res = (res * inv2) % MOD;
        seen[l][r] = true;
        return dp[l][r] = res;
    }

    private static void dfs(int u, int p) {
        parent[u] = p;
        in[u] = time++;
        for (int v : g[u]) {
            if (v != p) {
                d[v] = d[u] + 1;
                dfs(v, u);
            }
        }
        out[u] = time;
    }

    private static long modPow(long a, long n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            n /= 2;
        }
        return res;
    }

    private static void initParents() {
        parents = new int[h + 1][n];
        parents[0] = parent;
        for (int i = 1; i <= h; i++) {
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
