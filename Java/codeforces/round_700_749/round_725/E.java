package codeforces.round_700_749.round_725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    private static class Node {
        String full;
        String pre;
        String suff;
        long count;

        Node(String full, long count) {
            this.full = full;
            this.count = count;
        }

        Node(String pre, String suff, long count) {
            this.pre = pre;
            this.suff = suff;
            this.count = count;
        }
    }

    private static Node merge(Node l, Node r) {
        if (l.full == null && r.full == null) {
            return new Node(l.pre, r.suff, f(l.suff + r.pre) + l.count + r.count);
        }
        if (l.full == null) {
            String suff = l.suff + r.full;
            suff = suff.substring(suff.length() - 3);
            return new Node(l.pre, suff, f(l.suff + r.full) + l.count);
        }
        if (r.full == null) {
            String pre = l.full + r.pre;
            pre = pre.substring(0, 3);
            return new Node(pre, r.suff, f(l.full + r.pre) + r.count);
        }
        final String full = l.full + r.full;
        if (full.length() > 10) {
            return new Node(full.substring(0, 3), full.substring(full.length() - 3), f(full));
        } else {
            return new Node(full, f(full));
        }
    }

    private static int f(String s) {
        int res = 0;
        int idx = s.indexOf("haha");
        while (idx >= 0) {
            res++;
            idx = s.indexOf("haha", idx + 2);
        }
        return res;
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final Map<String, Node> map = new HashMap<>();
            long count = -1L;
            for (int i = 0; i < n; i++) {
                final String x = fs.next();
                final String op = fs.next();
                final String y = fs.next();
                if (":=".equals(op)) {
                    count = f(y);
                    map.put(x, new Node(y, count));
                } else {
                    fs.next();
                    final String z = fs.next();
                    final Node merge = merge(map.get(y), map.get(z));
                    count = merge.count;
                    map.put(x, merge);
                }
            }
            System.out.println(count);
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

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        private String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    //noinspection CallToPrintStackTrace
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int[] nextIntArray(int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) { a[i] = nextInt(); }
            return a;
        }

        long[] nextLongArray(int n) {
            final long[] a = new long[n];
            for (int i = 0; i < n; i++) { a[i] = nextLong(); }
            return a;
        }
    }
}
