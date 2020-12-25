package atcoder.beginner_100_199.beginner_139;

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

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final Map<Integer, List<Integer>> g = new HashMap<>();
        final int[] inDeg = new int[(int) (1e6 + 5)];
        for (int i = 1; i <= n; i++) {
            final int[] e = fs.nextIntArray(n - 1);
            for (int j = 1; j < e.length; j++) {
                final int u = Math.min(i, e[j - 1]) * 1000 + Math.max(i, e[j - 1]);
                final int v = Math.min(i, e[j]) * 1000 + Math.max(i, e[j]);
                g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
                inDeg[v]++;
            }
        }
        final Deque<Integer> q = new ArrayDeque<>();
        for (int key : g.keySet()) {
            if (inDeg[key] == 0) {
                q.offerLast(key);
            }
        }
        int res;
        int target = (n * (n - 1)) / 2;
        for (res = 0; !q.isEmpty(); res++) {
            for (int size = q.size(); size > 0; size--) {
                final int curr = q.removeFirst();
                target--;
                for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                    if (--inDeg[next] == 0) {
                        q.offerLast(next);
                    }
                }
            }
        }
        System.out.println(target == 0 ? res : -1);
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
