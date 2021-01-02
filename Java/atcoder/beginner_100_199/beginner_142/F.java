package atcoder.beginner_100_199.beginner_142;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt();
            final int v = fs.nextInt();
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
        }
        List<Integer> res = null;
        outer:
        for (int start = 1; start <= n; start++) {
            final Deque<Integer> q = new ArrayDeque<>();
            q.offerLast(start);
            final int[] prev = new int[n + 5];
            boolean flag = false;
            Arrays.fill(prev, -1);
            while (!q.isEmpty()) {
                int curr = q.removeFirst();
                if (flag && curr == start) {
                    final List<Integer> cycle = new ArrayList<>();
                    while (prev[curr] != start) {
                        cycle.add(curr);
                        curr = prev[curr];
                    }
                    cycle.add(curr);
                    if (res == null || res.size() > cycle.size()) {
                        res = cycle;
                        continue outer;
                    }
                }
                flag = true;
                for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                    if (prev[next] == -1) {
                        prev[next] = curr;
                        q.offerLast(next);
                    }
                }
            }
        }
        if (res == null) {
            System.out.println(-1);
            return;
        }
        System.out.println(res.size());
        Collections.reverse(res);
        for (int v : res) {
            System.out.println(v);
        }
    }

    static final class Utils {
        public static void shuffleSort(int[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffleSort(long[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffle(int[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void shuffle(long[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void swap(int[] arr, int i, int j) {
            final int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

        public static void swap(long[] arr, int i, int j) {
            final long t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
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
