package codeforces.custom.deltix_spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    static class Node {
        int val;
        String path;

        Node(String p, int t) {
            path = p;
            val = t;
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final StringBuilder sb = new StringBuilder();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final Deque<Node> dq = new ArrayDeque<>();
            dq.offerLast(new Node("", 0));
            for (int i = 0; i < n; i++) {
                final int next = fs.nextInt();
                if (dq.getFirst().val + 1 != next) {
                    if (next == 1) {
                        final Node peek = dq.getFirst();
                        final String p = peek.path.isEmpty() ? String.valueOf(peek.val)
                                                             : (peek.path + '.' + peek.val);
                        dq.addFirst(new Node(p, 1));
                    } else {
                        while (dq.getFirst().val + 1 != next) {
                            dq.removeFirst();
                        }
                        dq.getFirst().val++;
                    }
                } else {
                    dq.getFirst().val++;
                }
                add(sb, dq.getFirst(), dq.getFirst().val);
            }
        }
        System.out.println(sb);
    }

    private static void add(StringBuilder sb, Node node, int val) {
        final String p = node.path.isEmpty() ? String.valueOf(val)
                                             : (node.path + '.' + val);
        sb.append(p);
        sb.append('\n');
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
