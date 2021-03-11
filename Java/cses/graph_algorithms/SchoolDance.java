package cses.graph_algorithms;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Random;

public final class SchoolDance {

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int a = fs.nextInt();
        final int b = fs.nextInt();
        final int n = a + b;
        final int m = fs.nextInt();
        final int[][] g = new int[n + 2][n + 2];
        final int[][] edges = new int[6 * m][2];
        final int[][] dirEdges = new int[3 * m][2];
        int l = 0;
        int r = 0;
        final int s = 0;
        final int t = n + 1;
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt();
            final int v = a + fs.nextInt();
            g[s][u] = 1;
            g[u][v] = 1;
            g[v][t] = 1;
            dirEdges[r++] = edges[l++] = new int[] { s, u };
            dirEdges[r++] = edges[l++] = new int[] { u, v };
            dirEdges[r++] = edges[l++] = new int[] { v, t };
            edges[l++] = new int[] { u, s };
            edges[l++] = new int[] { v, u };
            edges[l++] = new int[] { t, v };
        }
        final int[][] adj = Utils.packG(edges, n + 2);
        final int[][] dirAdj = Utils.packG(dirEdges, n + 2);
        int res = 0;
        while (true) {
            final int flow = bfs(s, t, n + 2, g, adj);
            if (flow == 0) {
                break;
            }
            res += flow;
        }
        System.out.println(res);
        final boolean[][] seen = new boolean[n + 2][n + 2];
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res; i++) {
            final List<Integer> p = new ArrayList<>();
            dfs(s, t, seen, g, dirAdj, p);
            sb.append(p.get(1));
            sb.append(' ');
            sb.append(p.get(2) - a);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int bfs(int s, int t, int n, int[][] g, int[][] adj) {
        final Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(s);
        final int[] prev = new int[n];
        Arrays.fill(prev, -1);
        prev[s] = -2;
        boolean ok = false;
        while (!q.isEmpty()) {
            final int u = q.removeFirst();
            if (u == t) {
                ok = true;
                break;
            }
            for (int v : adj[u]) {
                if (g[u][v] > 0 && prev[v] == -1) {
                    prev[v] = u;
                    q.offerLast(v);
                }
            }
        }
        if (!ok) {
            return 0;
        }
        int p = t;
        int min = (int) 1e9;
        while (prev[p] != -2) {
            min = Math.min(min, g[prev[p]][p]);
            p = prev[p];
        }
        p = t;
        while (prev[p] != -2) {
            g[prev[p]][p] -= min;
            g[p][prev[p]] += min;
            p = prev[p];
        }
        return min;
    }

    private static boolean dfs(int u, int t, boolean[][] seen, int[][] g, int[][] adj, List<Integer> p) {
        if (u == t) {
            return true;
        }
        for (int v : adj[u]) {
            if (g[u][v] == 0 && !seen[u][v]) {
                seen[u][v] = true;
                p.add(u);
                if (dfs(v, t, seen, g, adj, p)) {
                    return true;
                }
                p.remove(p.size() - 1);
                seen[u][v] = false;
            }
        }
        return false;
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
