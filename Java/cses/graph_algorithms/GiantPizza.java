package cses.graph_algorithms;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class GiantPizza {

    // 2SAT
    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final List<List<List<int[]>>> g1 = new ArrayList<>(2);
        final List<List<List<int[]>>> g2 = new ArrayList<>(2);
        for (int i = 0; i < 2; i++) {
            g1.add(new ArrayList<>(m));
            g2.add(new ArrayList<>(m));
        }
        for (int i = 0; i < m; i++) {
            g1.get(0).add(new ArrayList<>());
            g1.get(1).add(new ArrayList<>());
            g2.get(0).add(new ArrayList<>());
            g2.get(1).add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            final int signU = fs.nextSign();
            final int u = fs.nextInt() - 1;
            final int signV = fs.nextSign();
            final int v = fs.nextInt() - 1;
            // not u -> v
            g1.get(1 - signU).get(u).add(new int[] { signV, v });
            // not v -> u
            g1.get(1 - signV).get(v).add(new int[] { signU, u });
            g2.get(signV).get(v).add(new int[] { 1 - signU, u });
            g2.get(signU).get(u).add(new int[] { 1 - signV, v });
        }
        final List<int[]> topSort = new ArrayList<>(2 * m);
        boolean[] seen = new boolean[2 * m];
        for (int i = 0; i < m; i++) {
            dfs1(new int[] { 0, i }, g1, seen, topSort, m);
            dfs1(new int[] { 1, i }, g1, seen, topSort, m);
        }
        seen = new boolean[2 * m];
        final int[] res = new int[2 * m];
        final boolean[] flag = new boolean[2 * m];
        int cc = 1;
        for (int i = topSort.size() - 1; i >= 0; i--) {
            final int[] u = topSort.get(i);
            if (!seen[u[1] + (u[0] == 1 ? m : 0)]) {
                dfs2(u, g2, seen, flag, res, m, cc);
                cc++;
            }
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(flag[i] ? '+' : '-');
            sb.append(' ');
        }
        System.out.println(sb);
    }

    private static void dfs1(int[] u, List<List<List<int[]>>> g, boolean[] seen, List<int[]> topSort, int m) {
        if (seen[u[1] + (u[0] == 1 ? m : 0)]) {
            return;
        }
        seen[u[1] + (u[0] == 1 ? m : 0)] = true;
        for (int[] v : g.get(u[0]).get(u[1])) {
            dfs1(v, g, seen, topSort, m);
        }
        topSort.add(u);
    }

    private static void dfs2(int[] u, List<List<List<int[]>>> g, boolean[] seen, boolean[] flag, int[] res,
                             int m, int cc) {
        if (seen[u[1] + (u[0] == 1 ? m : 0)]) {
            return;
        }
        seen[u[1] + (u[0] == 1 ? m : 0)] = true;
        for (int[] v : g.get(u[0]).get(u[1])) {
            dfs2(v, g, seen, flag, res, m, cc);
        }
        res[u[1] + (u[0] == 1 ? m : 0)] = cc;
        flag[u[1]] = u[0] == 0;
        if (res[u[1]] == res[u[1] + m]) {
            System.out.println("IMPOSSIBLE");
            System.exit(0);
        }
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
