package cses.graph_algorithms;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class TeleportersPath {

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final List<List<int[]>> g = new ArrayList<>(n);
        final boolean[] seen = new boolean[(int) (2e5 + 5)];
        final int[] inDeg = new int[n];
        final int[] outDeg = new int[n];
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            g.get(u).add(new int[] { v, i });
            outDeg[u]++;
            inDeg[v]++;
        }
        if (!hasEulerianPath(inDeg, outDeg, n)) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        final List<Integer> res = new ArrayList<>();
        final int[] stack = new int[(int) (2e5 + 5)];
        int j = 0;
        stack[j++] = 0;
        while (j > 0) {
            final int u = stack[j - 1];
            boolean flag = false;
            while (outDeg[u] > 0) {
                final int[] e = g.get(u).get(--outDeg[u]);
                if (!seen[e[1]]) {
                    seen[e[1]] = true;
                    stack[j++] = e[0];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                res.add(u);
                j--;
            }
        }
        if (res.size() != m + 1) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = res.size() - 1; i >= 0; i--) {
            sb.append(res.get(i) + 1);
            sb.append(' ');
        }
        System.out.println(sb);
    }

    private static boolean hasEulerianPath(int[] in, int[] out, int n) {
        int start = 0;
        int end = 0;
        int ii = -1;
        int jj = -1;
        for (int i = 0; i < n; i++) {
            if (Math.abs(in[i] - out[i]) > 1) {
                return false;
            }
            if (in[i] - out[i] == 1) {
                end++;
                jj = i;
            } else if (out[i] - in[i] == 1) {
                start++;
                ii = i;
            }
        }
        return start == 1 && end == 1 && ii == 0 && jj == n - 1;
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
