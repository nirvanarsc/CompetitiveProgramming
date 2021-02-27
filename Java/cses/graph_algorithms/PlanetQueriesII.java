package cses.graph_algorithms;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public final class PlanetQueriesII {

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        final boolean[] vis = new boolean[n];
        final int[] dp = new int[n];
        final int[][] parent = new int[20][n];
        for (int i = 0; i < n; i++) {
            parent[0][i] = fs.nextInt() - 1;
        }
        for (int i = 1; i < 20; ++i) {
            for (int j = 0; j < n; ++j) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, vis, parent, dp);
            }
        }
        for (int i = 0; i < q; i++) {
            final int x = fs.nextInt() - 1;
            final int y = fs.nextInt() - 1;
            int res = -1;
            // end of the cycle (Case: x and y are in cycle such that x appears after y)
            final int xRoot = lift(x, dp[x], parent);
            // if y is in front of x
            if (lift(x, dp[x] - dp[y], parent) == y) {
                res = dp[x] - dp[y];
            } else if (lift(xRoot, dp[xRoot] - dp[y], parent) == y) {
                res = dp[x] + dp[xRoot] - dp[y];
            }
            pw.println(res);
        }
        pw.close();
    }

    private static int lift(int x, int d, int[][] parent) {
        for (int i = 0; i < 20; i++) {
            if ((d & (1 << i)) != 0) {
                x = parent[i][x];
            }
        }
        return x;
    }

    private static void dfs(int u, boolean[] vis, int[][] parent, int[] dp) {
        if (vis[u]) {
            return;
        }
        vis[u] = true;
        dfs(parent[0][u], vis, parent, dp);
        dp[u] = dp[parent[0][u]] + 1;
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
