package cses.graph_algorithms;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public final class KnightTour {

    private static final int[][] DIRS =
            { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 } };

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int y = fs.nextInt() - 1;
        final int x = fs.nextInt() - 1;
        final int n = 8;
        final int[][] g = new int[n][n];
        g[x][y] = 1;
        dfs(g, x, y, 2, n);
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(g[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static boolean dfs(int[][] g, int x, int y, int move, int n) {
        if (move == n * n + 1) {
            return true;
        }
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(val -> val[0]));
        for (int[] dir : DIRS) {
            final int nx = x + dir[0];
            final int ny = y + dir[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && g[nx][ny] == 0) {
                pq.offer(new int[] { count(g, nx, ny, n), nx, ny });
            }
        }
        while (!pq.isEmpty()) {
            final int[] v = pq.remove();
            final int nx = v[1];
            final int ny = v[2];
            g[nx][ny] = move;
            if (dfs(g, nx, ny, move + 1, n)) {
                return true;
            }
            g[nx][ny] = 0;
        }
        return false;
    }

    private static int count(int[][] g, int x, int y, int n) {
        int res = 0;
        for (int[] dir : DIRS) {
            final int nx = x + dir[0];
            final int ny = y + dir[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && g[nx][ny] == 0) {
                res++;
            }
        }
        return res;
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
