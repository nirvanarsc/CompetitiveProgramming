package codeforces.educational_95;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            final int[] pos = fs.nextIntArray(n);
            final PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
            final PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < n; i++) {
                if (pos[i] == 0) {
                    pq1.offer(arr[i]);
                    pq2.offer(arr[i]);
                }
            }
            final int[] cand1 = new int[n];
            for (int i = 0; i < n; i++) {
                if (pos[i] == 1) {
                    cand1[i] = arr[i];
                } else {
                    cand1[i] = pq1.remove();
                }
            }
            int presum = cand1[0];
            boolean onlyPositive = true;
            for (int i = 1; i < n; i++) {
                if (presum < 0) {
                    onlyPositive = false;
                    break;
                }
                presum += cand1[i];
            }
            if (presum < 0) {
                onlyPositive = false;
            }
            if (onlyPositive) {
                for (int i = 0; i < n; i++) {
                    System.out.print(cand1[i] + " ");
                }
                System.out.println();
                continue;
            } else {
                for (int i = 0; i < n; i++) {
                    if (pos[i] == 1) {
                        System.out.print(arr[i] + " ");
                    } else {
                        System.out.print(pq2.remove() + " ");
                    }
                }
                System.out.println();
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
