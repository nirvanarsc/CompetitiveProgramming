package codeforces.global_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final PrintWriter pw = new PrintWriter(System.out);
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        int[] arr = fs.nextIntArray(n);
        final List<List<Integer>> operations = new ArrayList<>();
        while (true) {
            final List<Integer> currOps = new ArrayList<>();
            final Deque<List<Integer>> dq = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                final List<Integer> cc = new ArrayList<>();
                int j = i;
                cc.add(arr[j]);
                while (j + 1 < n && arr[j] + 1 == arr[j + 1]) {
                    cc.add(arr[++j]);
                }
                dq.add(cc);
                currOps.add(j - i + 1);
                i = j;
            }
            if (currOps.size() == 1) {
                break;
            }
            final int[] nextArr = new int[n];
            int idx = 0;
            while (!dq.isEmpty()) {
                final List<Integer> tt = dq.removeLast();
                for (int nn : tt) {
                    nextArr[idx++] = nn;
                }
            }
            operations.add(currOps);
            arr = nextArr;
        }
        pw.println(operations.size());
        for (List<Integer> op : operations) {
            pw.print(op.size() + " ");
            for (int nn : op) {
                pw.print(nn + " ");
            }
            pw.println();
        }
        pw.close();
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
