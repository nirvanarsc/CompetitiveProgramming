package cses.graph_algorithms;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Random;

public final class Monsters {

    static class Node {
        char p;
        int r;
        int c;

        Node(char p, int r, int c) {
            this.p = p;
            this.r = r;
            this.c = c;
        }
    }

    private static final int[][] DIRS = { { 0, 1, 0 }, { 0, -1, 1 }, { 1, 0, 2 }, { -1, 0, 3 } };

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = fs.readLine().toCharArray();
        }
        final String d = "RLDU";
        final Node[][] prev = new Node[n][m];
        final int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, (int) 1e9);
        }
        final Deque<int[]> monsters = new ArrayDeque<>();
        final int[] source = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'M') {
                    monsters.offerLast(new int[] { i, j, 0 });
                } else if (grid[i][j] == 'A') {
                    source[0] = i;
                    source[1] = j;
                }
            }
        }
        monsterBFS(monsters, dist, grid, n, m);
        final Deque<int[]> q = new ArrayDeque<>(Collections.singleton(source));
        final boolean[][] seen = new boolean[n][m];
        for (int level = 0; !q.isEmpty(); level++) {
            for (int size = q.size(); size > 0; size--) {
                final int[] curr = q.removeFirst();
                int x = curr[0];
                int y = curr[1];
                if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
                    System.out.println("YES");
                    System.out.println(curr[2]);
                    final char[] res = new char[curr[2]];
                    int idx = curr[2] - 1;
                    while (idx >= 0) {
                        final Node node = prev[x][y];
                        res[idx] = node.p;
                        x = node.r;
                        y = node.c;
                        idx--;
                    }
                    System.out.println(res);
                    return;
                }
                for (int[] dir : DIRS) {
                    final int nx = x + dir[0];
                    final int ny = y + dir[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == '.' && !seen[nx][ny]) {
                        if (dist[x][y] > level) {
                            seen[nx][ny] = true;
                            prev[nx][ny] = new Node(d.charAt(dir[2]), x, y);
                            q.offerLast(new int[] { nx, ny, level + 1 });
                        }
                    }
                }
            }
        }
        System.out.println("NO");
    }

    private static void monsterBFS(Deque<int[]> q, int[][] dist, char[][] grid, int n, int m) {
        final boolean[][] seen = new boolean[n][m];
        while (!q.isEmpty()) {
            final int[] curr = q.removeFirst();
            final int x = curr[0];
            final int y = curr[1];
            final int level = curr[2];
            dist[x][y] = Math.min(dist[x][y], level);
            for (int[] dir : DIRS) {
                final int nx = x + dir[0];
                final int ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] != '#' && !seen[nx][ny]) {
                    seen[nx][ny] = true;
                    q.offerLast(new int[] { nx, ny, level + 1 });
                }
            }
        }
    }

    static final class Utils {
        public static void shuffleSort(int[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffleSort(long[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffle(int[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void shuffle(long[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void swap(int[] x, int i, int j) {
            final int t = x[i];
            x[i] = x[j];
            x[j] = t;
        }

        public static void swap(long[] x, int i, int j) {
            final long t = x[i];
            x[i] = x[j];
            x[j] = t;
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
