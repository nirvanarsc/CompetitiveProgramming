package atcoder.beginner_136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] inDegrees = new int[n];
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
            inDegrees[u]++;
            inDegrees[v]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 1) {
                q.offerLast(i);
            }
        }
        int remaining = n;
        while (remaining > 2) {
            for (int size = q.size(); size > 0; size--) {
                final int curr = q.removeFirst();
                remaining--;
                System.out.println(curr);
                for(int next: g.getOrDefault(curr, Collections.emptyList())) {
                    if(--inDegrees[next] == 1) {
                        q.offerLast(next);
                    }
                }
            }
        }
        return new ArrayList<>(q);
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int k = fs.nextInt();
        final int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
            sum += arr[i];
        }
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int p = 1; p * p <= sum; p++) {
            if (sum % p == 0) {
                pq.add(p);
                if (p * p != sum) {
                    pq.add(sum / p);
                }
            }
        }
        while (!pq.isEmpty()) {
            final int curr = pq.poll();
            final int[] remainders = new int[n];
            for (int i = 0; i < n; i++) {
                remainders[i] = arr[i] % curr;
            }
            Arrays.sort(remainders);
            if (remainders[n - 1] == 0) {
                System.out.println(curr);
                return;
            }
            final long[] sums = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                sums[i] = sums[i - 1] + remainders[i - 1];
            }
            int tmp = 0;
            for (int i = n; i > 0; i--) {
                tmp += curr - remainders[i - 1];
                if (tmp > k) {
                    break;
                }
                if (tmp == sums[i - 1]) {
                    System.out.println(curr);
                    return;
                }
            }
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
