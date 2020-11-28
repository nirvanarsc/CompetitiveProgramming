package codeforces.round_600_649.round_649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[] arr = fs.nextIntArray(n);
        final boolean[] banned = new boolean[(int) (2e5 + 5)];
        final TreeSet<Integer> mex = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            banned[arr[i]] = true;
            mex.add(i);
        }
        mex.add(n);
        int curr = getCurr(0, banned);
        mex.remove(curr);
        if (mex.first() != arr[0]) {
            System.out.println(-1);
            return;
        }
        final List<Integer> res = new ArrayList<>();
        res.add(curr);
        curr = getCurr(curr + 1, banned);
        for (int i = 1; i < n; i++) {
            final boolean check = arr[i - 1] != arr[i];
            if (check) {
                res.add(arr[i - 1]);
                mex.remove(arr[i - 1]);
                if (mex.first() != arr[i]) {
                    System.out.println(-1);
                    return;
                }
            } else {
                res.add(curr);
                mex.remove(curr);
                curr = getCurr(curr + 1, banned);
            }
        }
        for (int num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static int getCurr(int curr, boolean[] banned) {
        while (banned[curr]) {
            curr++;
        }
        return curr;
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
