package codeforces.global_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int k = fs.nextInt();
            final char[] s = fs.next().toCharArray();
            final TreeSet<Integer> idx = new TreeSet<>();
            final TreeMap<int[], TreeSet<Integer>> pq = new TreeMap<>(
                    (a, b) -> Math.min(b[0], b[1]) == Math.min(a[0], a[1])
                              ? Integer.compare(a[0] + a[1], b[0] + b[1])
                              : Integer.compare(Math.min(a[0], a[1]), Math.min(b[0], b[1])));
            for (int i = 0; i < n; i++) {
                if (s[i] == 'L') {
                    idx.add(i);
                }
            }
            for (int i = 0; i < n; i++) {
                if (s[i] == 'L') {
                    final int[] key = tt(n, idx, i);
//                    System.out.println(key);
                    pq.computeIfAbsent(key, v -> new TreeSet<>()).add(i);
                }
            }
            for (int i = 0; i < k && !pq.isEmpty(); i++) {
                final Entry<int[], TreeSet<Integer>> cc = pq.pollLastEntry();
                int index = cc.getValue().pollFirst();
                if (!cc.getValue().isEmpty()) {
                    pq.put(cc.getKey(), cc.getValue());
                }
                final Integer hh = idx.higher(index);
                final Integer ll = idx.lower(index);
                if (hh != null) {
                    final int[] Hkey = tt(n, idx, hh);
                    pq.get(Hkey).remove(hh);
                    if (pq.get(Hkey).isEmpty()) {
                        pq.remove(Hkey);
                    }
                }
                if (ll != null) {
                    final int[] LKey = tt(n, idx, ll);
                    pq.get(LKey).remove(ll);
                    if (pq.get(LKey).isEmpty()) {
                        pq.remove(LKey);
                    }
                }
                s[index] = 'W';
                idx.remove(index);
                if (hh != null) {
                    final int[] Hkey = tt(n, idx, hh);
                    pq.computeIfAbsent(Hkey, v -> new TreeSet<>()).add(hh);
                }
                if (ll != null) {
                    final int[] Lkey = tt(n, idx, ll);
                    pq.computeIfAbsent(Lkey, v -> new TreeSet<>()).add(ll);
                }
            }
            int currScore = 0;
            for (int i = 0; i < n; i++) {
                if (s[i] == 'W') {
                    if (i > 0 && s[i - 1] == 'W') {
                        currScore++;
                    }
                    currScore++;
                }
            }
            System.out.println(currScore);
        }
    }

    private static int[] tt(int n, TreeSet<Integer> idx, Integer a) {
        Integer lower = idx.lower(a);
        if (lower == null) {
            lower = 0;
        }
        Integer higher = idx.higher(a);
        if (higher == null) {
            higher = n;
        }
        return new int[] { higher - a, a - lower };
    }

    private static void addToPq(int n, int[] calc, PriorityQueue<int[]> pq, int i) {
        int currValue = 0;
        if (i > 0 && calc[i - 1] != -1) {
            currValue += calc[i - 1];
        }
        if (i < n - 1 && calc[i + 1] != -1) {
            currValue += calc[i + 1];
        }
        pq.offer(new int[] { i, currValue });
    }

    private static int[] getRow(int n, char[] grid) {
        final int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            if (grid[i] == 'L') {
                row[i] = -1;
            } else {
                int tt = i;
                while (tt < n && grid[tt] == 'W') {
                    tt++;
                }
                for (int k = i; k < tt; k++) {
                    row[k] = tt - i;
                }
                i = tt - 1;
            }
        }
        return row;
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
