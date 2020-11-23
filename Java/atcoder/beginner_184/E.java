package atcoder.beginner_184;

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

public final class E {

    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = fs.next().toCharArray();
        }
        final Map<Character, List<int[]>> teleports = new HashMap<>();
        final int[] start = { -1, -1 };
        final int[] end = { -1, -1 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                final char c = grid[i][j];
                if (c == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (c == 'G') {
                    end[0] = i;
                    end[1] = j;
                } else if ('a' <= c && c <= 'z') {
                    teleports.computeIfAbsent(c, val -> new ArrayList<>()).add(new int[] { i, j });
                }
            }
        }
        final boolean[][] seen = new boolean[n][m];
        final boolean[] usedTeleports = new boolean[26];
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[] { start[0], start[1], 0 });
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int x = curr[0];
            final int y = curr[1];
            final int cost = curr[2];
            if (x == end[0] && y == end[1]) {
                System.out.println(cost);
                return;
            }
            if (seen[x][y]) {
                continue;
            }
            seen[x][y] = true;
            for (int[] dir : DIRS) {
                final int nx = x + dir[0];
                final int ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] != '#') {
                    pq.offer(new int[] { nx, ny, cost + 1 });
                }
            }
            if ('a' <= grid[x][y] && grid[x][y] <= 'z') {
                if (!usedTeleports[grid[x][y] - 'a']) {
                    usedTeleports[grid[x][y] - 'a'] = true;
                    for (int[] next : teleports.getOrDefault(grid[x][y], Collections.emptyList())) {
                        pq.offer(new int[] { next[0], next[1], cost + 1 });
                    }
                }
            }
        }
        System.out.println(-1);
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
