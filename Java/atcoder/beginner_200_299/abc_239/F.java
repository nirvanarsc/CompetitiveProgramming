package atcoder.beginner_200_299.abc_239;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;

public final class F {

    private static final class UnionFind {

        private final int[] parent;
        private final int[] size;
        private int count;

        private UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p) {
            // path compression
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            final int rootP = find(p);
            final int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            // union by size
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
                size[rootQ] = 0;
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
                size[rootP] = 0;
            }
            count--;
        }

        public int count() {
            return count;
        }

        public int[] size() {
            return size;
        }
    }

    @SuppressWarnings("ConstantConditions")
    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int[] d = fs.nextIntArray(n);
        final UnionFind uf = new UnionFind(n);
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            if (uf.find(u) == uf.find(v) || --d[u] < 0 || --d[v] < 0) {
                System.out.println(-1);
                return;
            }
            uf.union(u, v);
        }
        final int[] dd = new int[n];
        final StringBuilder sb = new StringBuilder();
        final TreeSet<Integer> ts = new TreeSet<>(
                (a, b) -> dd[a] == dd[b] ? Integer.compare(a, b) : Integer.compare(dd[a], dd[b]));
        final Map<Integer, Deque<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (d[i] > 0) {
                dd[uf.find(i)] += d[i];
                g.computeIfAbsent(uf.find(i), val -> new ArrayDeque<>()).addFirst(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (dd[i] > 0) {
                ts.add(i);
            }
        }
        while (!ts.isEmpty()) {
            if (ts.size() == 1) {
                System.out.println(-1);
                return;
            }
            final int l = ts.pollLast();
            final int r = ts.pollFirst();
            final int u = g.get(l).removeFirst();
            final int v = g.get(r).removeFirst();
            uf.union(u, v);
            if (uf.find(u) == l) {
                g.get(l).addAll(g.get(r));
                if (--d[u] > 0) {
                    g.get(l).addFirst(u);
                }
                if (--d[v] > 0) {
                    g.get(l).addFirst(v);
                }
                dd[l] += dd[r];
                dd[l] -= 2;
                if (dd[l] > 0) {
                    ts.add(l);
                }
            } else {
                g.get(r).addAll(g.get(l));
                if (--d[u] > 0) {
                    g.get(r).addFirst(u);
                }
                if (--d[v] > 0) {
                    g.get(r).addFirst(v);
                }
                dd[r] += dd[l];
                dd[r] -= 2;
                if (dd[r] > 0) {
                    ts.add(r);
                }
            }
            sb.append(u + 1);
            sb.append(' ');
            sb.append(v + 1);
            sb.append('\n');
        }
        System.out.println(uf.count > 1 ? -1 : sb);
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

        private Utils() {
        }
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

        public int readSign() throws IOException {
            byte c = read();
            while ('+' != c && '-' != c) {
                c = read();
            }
            return '+' == c ? 0 : 1;
        }

        private static boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() throws IOException {
            int b;
            //noinspection StatementWithEmptyBody
            while ((b = read()) != -1 && isSpaceChar(b)) {
            }
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
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) {
                return -ret;
            }
            return ret;
        }

        public int[] nextIntArray(int n) throws IOException {
            final int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = nextInt();
            }
            return res;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            final boolean neg = c == '-';
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public long[] nextLongArray(int n) throws IOException {
            final long[] res = new long[n];
            for (int i = 0; i < n; i++) {
                res[i] = nextLong();
            }
            return res;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            final boolean neg = c == '-';
            if (neg) {
                c = read();
            }

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg) {
                return -ret;
            }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            din.close();
        }
    }
}
