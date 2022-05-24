package codeforces.round_750_799.round_793;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public final class E {

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt() - 1;
        }
        final Map<Integer, Set<String>> g = new HashMap<>();
        final Deque<int[]> dq = new ArrayDeque<>();
        final int[] inDeg = new int[n];
        final int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            inDeg[u]++;
            inDeg[v]++;
            edges[i] = new int[] { u, v };
            g.computeIfAbsent(u, val -> new HashSet<>()).add(v + "," + i);
            g.computeIfAbsent(v, val -> new HashSet<>()).add(u + "," + i);
        }
        for (int i = 0; i < m; i++) {
            final int u = edges[i][0];
            final int v = edges[i][1];
            if (inDeg[u] == 1 && arr[v] == u) {
                dq.offerLast(new int[] { u, v, i });
                g.get(u).remove(v + "," + i);
                g.get(v).remove(u + "," + i);
            } else if (inDeg[v] == 1 && arr[u] == v) {
                dq.offerLast(new int[] { u, v, i });
                g.get(u).remove(v + "," + i);
                g.get(v).remove(u + "," + i);
            }
        }
        final StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            final int[] curr = dq.removeFirst();
            final int u = curr[0];
            final int v = curr[1];
            inDeg[u]--;
            inDeg[v]--;
            sb.append(curr[2] + 1).append(' ');
            final int temp = arr[u];
            arr[u] = arr[v];
            arr[v] = temp;
            final Set<String> uuv = g.getOrDefault(u, new HashSet<>());
            final List<String> popUuv = new ArrayList<>();
            final Set<String> vvu = g.getOrDefault(v, new HashSet<>());
            final List<String> popVvu = new ArrayList<>();
            for (String uv : uuv) {
                final int edge = Integer.parseInt(uv.substring(0, uv.indexOf(',')));
                final int id = Integer.parseInt(uv.substring(uv.indexOf(',') + 1));
                if (inDeg[u] == 1 && arr[edge] == u) {
                    dq.offerLast(new int[] { u, edge, id });
                    popUuv.add(uv);
                    g.getOrDefault(edge, new HashSet<>()).remove(u + "," + id);
                } else if (inDeg[edge] == 1 && arr[u] == edge) {
                    dq.offerLast(new int[] { u, edge, id });
                    popUuv.add(uv);
                    g.getOrDefault(edge, new HashSet<>()).remove(u + "," + id);
                }
            }
            for (String vu : vvu) {
                final int edge = Integer.parseInt(vu.substring(0, vu.indexOf(',')));
                final int id = Integer.parseInt(vu.substring(vu.indexOf(',') + 1));
                if (inDeg[v] == 1 && arr[edge] == v) {
                    dq.offerLast(new int[] { v, edge, id });
                    popVvu.add(vu);
                    g.getOrDefault(edge, new HashSet<>()).remove(v + "," + id);
                } else if (inDeg[edge] == 1 && arr[v] == edge) {
                    dq.offerLast(new int[] { v, edge, id });
                    popVvu.add(vu);
                    g.getOrDefault(edge, new HashSet<>()).remove(v + "," + id);
                }
            }
            for (String p : popUuv) {
                uuv.remove(p);
            }
            for (String p : popVvu) {
                vvu.remove(p);
            }
        }
        if (sb.length() > 0) {
            sb.setCharAt(sb.length() - 1, '\n');
        }
        System.out.println(sb);
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
