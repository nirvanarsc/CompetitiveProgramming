package atcoder.beginner_200_299.abc_224;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class E {

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int h = fs.nextInt();
        final int w = fs.nextInt();
        final int n = fs.nextInt();
        final Map<Integer, List<int[]>> row = new HashMap<>();
        final Map<Integer, List<int[]>> col = new HashMap<>();
        final Map<Integer, List<Integer>> g = new HashMap<>();
        final int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] { fs.nextInt(), fs.nextInt(), fs.nextInt(), i };
            row.computeIfAbsent(arr[i][0], val -> new ArrayList<>()).add(arr[i]);
            col.computeIfAbsent(arr[i][1], val -> new ArrayList<>()).add(arr[i]);
        }
        for (List<int[]> value : row.values()) {
            value.sort((a, b) -> a[2] == b[2] ? Integer.compare(b[0], a[0]) : Integer.compare(a[2], b[2]));
        }
        for (List<int[]> value : col.values()) {
            value.sort((a, b) -> a[2] == b[2] ? Integer.compare(b[1], a[1]) : Integer.compare(a[2], b[2]));
        }
        final int[] inDeg = new int[n];
        for (int[] p : arr) {
            final int l = lowerBound(p[2] + 1, row.get(p[0]));
            final int r = lowerBound(p[2] + 1, col.get(p[1]));
            final int u = p[3];
            int v;
            if (l != -1) {
                v = row.get(p[0]).get(l)[3];
                g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
                inDeg[v]++;
            }
            if (r != -1) {
                v = col.get(p[1]).get(r)[3];
                g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
                inDeg[v]++;
            }
        }
        final int[] topSort = topSort(g, inDeg, n);
        final int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            final int u = topSort[i];
            for (int v : g.getOrDefault(u, Collections.emptyList())) {
                if (dp[v] + 1 > dp[u]) {
                    dp[u] = dp[v] + 1;
                }
            }
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(dp[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static int lowerBound(int target, List<int[]> list) {
        int lo = 0;
        int hi = list.size();
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (list.get(mid)[2] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo == list.size() ? -1 : lo;
    }

    private static int[] topSort(Map<Integer, List<Integer>> g, int[] inDeg, int n) {
        final Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                dq.offerLast(i);
            }
        }
        final int[] res = new int[n];
        for (int i = 0; !dq.isEmpty(); i++) {
            final int u = dq.removeFirst();
            res[i] = u;
            for (int v : g.getOrDefault(u, Collections.emptyList())) {
                if (--inDeg[v] == 0) {
                    dq.offerLast(v);
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
