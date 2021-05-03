package codeforces.global_14;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class G {

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static List<List<int[]>> g1;
    static List<List<int[]>> g2;

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        g1 = new ArrayList<>(n);
        g2 = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g1.add(new ArrayList<>());
            g2.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            final int w = fs.nextInt();
            g1.get(u).add(new int[] { v, w });
            g2.get(v).add(new int[] { u, w });
        }
        final List<Integer> topSort = new ArrayList<>(n);
        boolean[] seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs1(i, seen, topSort);
        }
        int ccNum = 0;
        seen = new boolean[n];
        final int[] cc = new int[n];
        final int[] ccRoot = new int[n];
        Arrays.fill(cc, -1);
        for (int i = n - 1; i >= 0; i--) {
            final int u = topSort.get(i);
            if (cc[u] == -1) {
                dfs2(u, seen, cc, ccNum);
                ccRoot[ccNum++] = u;
            }
        }
        final long[] depth = new long[n];
        Arrays.fill(depth, -1);
        final long[] gcd = new long[n];
        for (int i = 0; i < ccNum; i++) {
            dfs3(ccRoot[i], 0, depth, gcd, cc);
        }
        final int q = fs.nextInt();
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            final int u = fs.nextInt() - 1;
            final int s = fs.nextInt();
            final int t = fs.nextInt();
            final int ccIdx = cc[u];
            if (gcd[ccIdx] == 0) {
                sb.append(s == 0 ? "YES\n" : "NO\n");
            } else {
                final long currGcd = gcd(gcd[ccIdx], t);
                sb.append(s % currGcd == 0 ? "YES\n" : "NO\n");
            }
        }
        System.out.println(sb);
    }

    private static void dfs1(int u, boolean[] seen, List<Integer> topSort) {
        if (seen[u]) {
            return;
        }
        seen[u] = true;
        for (int[] v : g1.get(u)) {
            dfs1(v[0], seen, topSort);
        }
        topSort.add(u);
    }

    private static void dfs2(int u, boolean[] seen, int[] cc, int ccIdx) {
        if (seen[u]) {
            return;
        }
        seen[u] = true;
        for (int[] v : g2.get(u)) {
            dfs2(v[0], seen, cc, ccIdx);
        }
        cc[u] = ccIdx;
    }

    private static void dfs3(int u, long d, long[] depth, long[] gcd, int[] cc) {
        depth[u] = d;
        for (int[] next : g1.get(u)) {
            final int v = next[0];
            final int c = next[1];
            if (cc[u] != cc[v]) {
                continue;
            }
            if (depth[v] == -1) {
                dfs3(v, d + c, depth, gcd, cc);
            } else {
                gcd[cc[u]] = gcd(gcd[cc[u]], Math.abs(d + c - depth[v]));
            }
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
