package cses.graph_algorithms;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@SuppressWarnings("StringRepeatCanBeUsed")
public final class DeBruijnSequence {

    /*
01 0000 0000 0000 0001
10 0000 0000 0000 0002
01 0000 0000 0000 0010

     */


    public String crackSafe(int n, int k) {
        final int nodes = 1 << 16;
        final Map<Integer, List<int[]>> g = new HashMap<>();
        final Map<Integer, Integer> deg = new HashMap<>();
        int edgeIdx = 0;
        final int andMask = (1 << 16) - 1;
        for (int i = 0; i <= (int) Math.pow(n - 1, k); i++) {
            final String mask = Integer.toString(i, k);
            char[] maskie = new char[4];
            Arrays.fill(maskie, '0');
            for (int j = maskie.length - 1, tt = mask.length() - 1; tt >= 0; j--, tt--) {
                maskie[j] = mask.charAt(tt);
            }
            // pad string like "10" to "0010"
            char[] m = new char[16];
            int idx = 0;
            for (int j = 0; j < 4; j++) {
                int bits = maskie[j] - '0';
                for (int l = 3; l >= 0; l--) {
                    m[idx] = (bits & (1 << l)) != 0 ? '1' : '0';
                    idx++;
                }
            }
            String mm = new String(m);
            System.out.println(mm + " " + new String(maskie));
            for (int j = 0; j < k; j++) {
                char[] next = new char[16];
                System.arraycopy(m, 4, next, 0, 12);
                for (int l = 12, t = 3; l < 16; l++, t--) {
                    next[l] = (j & (1 << t)) != 0 ? '1' : '0';
                }
                System.out.println(next);
                g.computeIfAbsent(Integer.parseInt(mm), val -> new ArrayList<>())
                 .add(new int[] { Integer.parseInt(new String(next)), j, edgeIdx++  });
                deg.merge(Integer.parseInt(mm), 1, Integer::sum);
            }
        }
        final List<Integer> res = new ArrayList<>();
        final int[] stack = new int[(1 << 16) + 1];
        final int[] stack2 = new int[(1 << 16) + 1];
        final boolean[] seen = new boolean[edgeIdx];
        int s1 = 0;
        int s2 = 0;
        stack[s1++] = 0;
        stack2[s2++] = -1;
        while (s1 > 0) {
            final int u = stack[s1 - 1];
            final int edge = stack2[s2 - 1];
            boolean flag = false;
            System.out.println(u);
            while (deg.get(u) > 0) {
                final int[] e = g.get(u).get(deg.merge(u, -1, Integer::sum));
                if (!seen[e[2]]) {
                    seen[e[2]] = true;
                    stack[s1++] = e[0];
                    stack2[s2++] = e[1];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                if (edge != -1) {
                    res.add(edge);
                }
                s1--;
                s2--;
            }
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.append(0);
        }
        for (int i = res.size() - 1; i >= 0; i--) {
            sb.append(res.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        new DeBruijnSequence().crackSafe(3, 3);

//        final FastReader fs = new FastReader();
//        final int n = fs.nextInt();
//        final int nodes = 1 << (n - 1);
//        final List<List<int[]>> g = new ArrayList<>(nodes);
//        final int[] deg = new int[nodes];
//        for (int i = 0; i < nodes; i++) {
//            g.add(new ArrayList<>());
//        }
//        int edgeIdx = 0;
//        final int andMask = nodes - 1;
//        for (int mask = 0; mask < nodes; mask++) {
//            for (int i = 0; i < 2; i++) {
//                g.get(mask).add(new int[] { (mask << 1 | i) & andMask, edgeIdx++ });
//                deg[mask]++;
//            }
//        }
//        final List<Integer> res = new ArrayList<>();
//        final int[] stack = new int[(1 << 15) + 1];
//        final int[] stack2 = new int[(1 << 15) + 1];
//        final boolean[] seen = new boolean[edgeIdx];
//        int s1 = 0;
//        int s2 = 0;
//        stack[s1++] = 0;
//        stack2[s2++] = -1;
//        while (s1 > 0) {
//            final int u = stack[s1 - 1];
//            final int edge = stack2[s2 - 1];
//            boolean flag = false;
//            while (deg[u] > 0) {
//                final int[] e = g.get(u).get(--deg[u]);
//                if (!seen[e[1]]) {
//                    seen[e[1]] = true;
//                    stack[s1++] = e[0];
//                    stack2[s2++] = e[1] & 1;
//                    flag = true;
//                    break;
//                }
//            }
//            if (!flag) {
//                if (edge != -1) {
//                    res.add(edge);
//                }
//                s1--;
//                s2--;
//            }
//        }
//        final StringBuilder sb = new StringBuilder();
//        for (int i = 1; i < n; i++) {
//            sb.append(0);
//        }
//        for (int i = res.size() - 1; i >= 0; i--) {
//            sb.append(res.get(i));
//        }
//        System.out.println(sb);
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
