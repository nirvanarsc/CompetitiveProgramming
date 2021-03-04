package codeforces.educational.educational_105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

public final class C {

    private static int lowerBound(List<Integer> arr, int target) {
        int lo = 0, hi = arr.size();
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int f(List<Integer> a, List<Integer> b) {
        final Set<Integer> seen = new HashSet<>(a);
        final int[] pre = new int[b.size() + 1];
        for (int i = 1; i <= b.size(); i++) {
            pre[i] = pre[i - 1] + (seen.contains(b.get(i - 1)) ? 1 : 0);
        }
        int res = pre[b.size()];
        for (int i = 0; i < b.size(); i++) {
            final int lo = lowerBound(a, b.get(i));
            final int len = i - lowerBound(b, b.get(i) - lo + 1) + 1;
            final int currMatching = pre[b.size()] - pre[i + 1];
            res = Math.max(res, len + currMatching);
        }
        return res;
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final List<Integer> negA = new ArrayList<>();
            final List<Integer> posA = new ArrayList<>();
            final List<Integer> negB = new ArrayList<>();
            final List<Integer> posB = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                final int curr = fs.nextInt();
                if (curr < 0) {
                    negA.add(-curr);
                } else {
                    posA.add(curr);
                }
            }
            for (int i = 0; i < m; i++) {
                final int curr = fs.nextInt();
                if (curr < 0) {
                    negB.add(-curr);
                } else {
                    posB.add(curr);
                }
            }
            Collections.reverse(negA);
            Collections.reverse(negB);
            System.out.println(f(negA, negB) + f(posA, posB));
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
