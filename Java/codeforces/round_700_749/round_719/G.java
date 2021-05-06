package codeforces.round_700_749.round_719;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Random;

public final class G {

    private static final int[][] DIRS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int w = fs.nextInt();
        final int[][] g = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = fs.nextInt();
            }
        }
        final List<int[]> portals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] > 0) {
                    portals.add(new int[] { i, j });
                }
            }
        }
        final long[][] start = bfs(0, 0, n, m, w, g);
        final long[][] end = bfs(n - 1, m - 1, n, m, w, g);
        long res = start[n - 1][m - 1];
        long L = (long) 3e18;
        long R = (long) 3e18;
        for (int[] portal : portals) {
            final int u = portal[0];
            final int v = portal[1];
            L = Math.min(L, g[u][v] + start[u][v]);
            R = Math.min(R, g[u][v] + end[u][v]);
        }
        res = Math.min(res, L + R);
        System.out.println(res == (long) 3e18 ? -1 : res);
    }

    private static long[][] bfs(int sx, int sy, int n, int m, int w, int[][] g) {
        final Deque<long[]> dq = new ArrayDeque<>();
        dq.offerLast(new long[] { 0, sx, sy });
        final long[][] res = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = (long) 3e18;
            }
        }
        res[sx][sy] = 0;
        while (!dq.isEmpty()) {
            final long[] curr = dq.removeFirst();
            final long cost = curr[0];
            final int x = (int) curr[1];
            final int y = (int) curr[2];
            if (res[x][y] < cost) {
                continue;
            }
            res[x][y] = cost;
            for (int[] dir : DIRS) {
                final int nx = dir[0] + x;
                final int ny = dir[1] + y;
                if (0 <= nx && nx < n && 0 <= ny && ny < m && g[nx][ny] != -1) {
                    final long nw = cost + w;
                    if (res[nx][ny] > nw) {
                        res[nx][ny] = nw;
                        dq.offerLast(new long[] { nw, nx, ny });
                    }
                }
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
