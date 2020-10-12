package codeforces.round_675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int[] start = { fs.nextInt(), fs.nextInt() };
        final int[] end = { fs.nextInt(), fs.nextInt() };
        final int[][] byX = new int[m][2];
        final int[][] byY = new int[m][2];
        final int[][] orig = new int[m][2];
        final Map<int[], Integer> idx = new HashMap<>();
        final Map<Integer, List<long[]>> g = new HashMap<>();
        for (int i = 0; i < m; i++) {
            final int[] curr = { fs.nextInt(), fs.nextInt() };
            byX[i] = curr;
            byY[i] = curr;
            orig[i] = curr;
            idx.put(curr, i);
        }
        Arrays.sort(byX, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        Arrays.sort(byY, (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        for (int j = 0; j < m; j++) {
            final int[] currX = byX[j];
            final int[] currY = byY[j];
            final int iX = idx.get(currX);
            final int iY = idx.get(currY);
            final List<long[]> edgeX = g.computeIfAbsent(iX, val -> new ArrayList<>());
            final List<long[]> edgeY = g.computeIfAbsent(iY, val -> new ArrayList<>());
            final List<long[]> edgeEnd = g.computeIfAbsent(j, val -> new ArrayList<>());
            if (j > 0) {
                edgeX.add(new long[] { idx.get(byX[j - 1]), distance(byX[j - 1], currX) });
                edgeY.add(new long[] { idx.get(byY[j - 1]), distance(byY[j - 1], currY) });
            }
            if (j < m - 1) {
                edgeX.add(new long[] { idx.get(byX[j + 1]), distance(byX[j + 1], currX) });
                edgeY.add(new long[] { idx.get(byY[j + 1]), distance(byY[j + 1], currY) });
            }
            edgeEnd.add(new long[] { m, manhattanDistance(orig[j], end) });
        }
        final PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(v -> v[1]));
        final boolean[] seen = new boolean[m];
        for (int j = 0; j < m; j++) {
            q.offer(new long[] { j, distance(orig[j], start) });
        }
        q.offer(new long[] { m, manhattanDistance(start, end) });
        while (!q.isEmpty()) {
            final long[] curr = q.remove();
            final int currIdx = (int) curr[0];
            if (currIdx == m) {
                System.out.println(curr[1]);
                return;
            }
            if (seen[currIdx]) {
                continue;
            }
            seen[currIdx] = true;
            for (long[] next : g.getOrDefault(currIdx, Collections.emptyList())) {
                q.offer(new long[] { next[0], curr[1] + next[1] });
            }
        }
    }

    private static long manhattanDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    private static long distance(int[] a, int[] b) {
        return Math.min(Math.abs(a[0] - b[0]), Math.abs(a[1] - b[1]));
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
