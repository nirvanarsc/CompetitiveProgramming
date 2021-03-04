package cses.graph_algorithms;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class CoinCollector {

    // SCC + DP
    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int[] k = new int[n];
        for (int i = 0; i < n; i++) {
            k[i] = fs.nextInt();
        }
        final List<List<Integer>> g1 = new ArrayList<>(n);
        final List<List<Integer>> g2 = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g1.add(new ArrayList<>());
            g2.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            g1.get(u).add(v);
            g2.get(v).add(u);
        }
        final List<Integer> topSort = new ArrayList<>(n);
        boolean[] seen = new boolean[n];
        final int[] scc = new int[n];
        for (int i = 0; i < n; i++) {
            dfs1(i, g1, seen, topSort);
        }
        seen = new boolean[n];
        int cc = 0;
        for (int i = n - 1; i >= 0; i--) {
            final int u = topSort.get(i);
            if (!seen[u]) {
                dfs2(u, g2, seen, scc, cc);
                cc++;
            }
        }
        ++cc;
        final List<List<Integer>> revSCCg = new ArrayList<>(cc);
        final long[] total = new long[cc];
        final long[] dp = new long[cc];
        for (int i = 0; i < n; i++) {
            total[scc[i]] += k[i];
        }
        for (int i = 0; i < cc; i++) {
            revSCCg.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int v : g2.get(i)) {
                if (scc[v] == scc[i]) {
                    continue;
                }
                revSCCg.get(scc[v]).add(scc[i]);
            }
        }
        for (int i = cc - 1; i >= 0; i--) {
            dp[i] = total[i];
            for (int j : revSCCg.get(i)) {
                dp[i] = Math.max(dp[i], dp[j] + total[i]);
            }
        }
        long res = 0;
        for (long dd : dp) {
            res = Math.max(res, dd);
        }
        System.out.println(res);
    }

    private static void dfs1(int u, List<List<Integer>> g, boolean[] seen, List<Integer> topSort) {
        if (seen[u]) {
            return;
        }
        seen[u] = true;
        for (int v : g.get(u)) {
            dfs1(v, g, seen, topSort);
        }
        topSort.add(u);
    }

    private static void dfs2(int u, List<List<Integer>> g, boolean[] seen, int[] scc, int cc) {
        if (seen[u]) {
            return;
        }
        seen[u] = true;
        for (int v : g.get(u)) {
            dfs2(v, g, seen, scc, cc);
        }
        scc[u] = cc;
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
