package codeforces.round_668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            final Deque<Integer> positives = new ArrayDeque<>();
            final Deque<Integer> negatives = new ArrayDeque<>();
            for (int k = 0; k < n; k++) {
                if (arr[k] < 0) {
                    negatives.addFirst(k);
                } else if (arr[k] > 0) {
                    positives.addFirst(k);
                }
            }
            long res = 0;
            while (!negatives.isEmpty() && !positives.isEmpty() && negatives.getLast() < positives.getFirst()) {
                if (negatives.getFirst() > positives.getFirst()) {
                    final int i = positives.removeFirst();
                    final int j = negatives.removeFirst();
                    final int diff = Math.min(arr[i], -arr[j]);
                    arr[j] += diff;
                    arr[i] -= diff;
                    if (arr[i] > 0) {
                        positives.addFirst(i);
                    } else {
                        negatives.addFirst(j);
                    }
                } else {
                    final int i = positives.removeFirst();
                    final int j = negatives.removeLast();
                    arr[j] += arr[i];
                    res += arr[i];
                    if (arr[j] > 0) {
                        positives.addLast(j);
                    } else if (arr[j] < 0) {
                        negatives.addLast(j);
                    }
                }
            }
            System.out.println(res);
        }
    }

    static final class Util {
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

        private Util() {}
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
