package kickstart.year_2019.round_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;
import java.util.StringTokenizer;

import utils.DataStructures.TreeNode;

public final class B {

    public void flatten(TreeNode root) {
        dfs(root);
    }

    private static TreeNode[] dfs(TreeNode node) {
        if (node == null) {
            return new TreeNode[] { null, null };
        }
        final TreeNode[] l = dfs(node.left);
        final TreeNode[] r = dfs(node.right);
        //noinspection ConstantConditions
        node.left = null;
        node.right = l[0];
        if (l[1] != null) {
            l[1].right = r[0];
        } else {
            node.right = r[0];
        }
        return new TreeNode[] { node, r[1] == null ? l[1] == null ? node : l[1] : r[1] };
    }

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int x = 1; x <= t; x++) {
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final char[][] g = new char[n][m];
            final int[][] d = new int[n][m];
            final Deque<int[]> dq = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                g[i] = fs.next().toCharArray();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (g[i][j] == '0') {
                        d[i][j] = (int) 1e9;
                    } else {
                        dq.offerLast(new int[] { i, j });
                    }
                }
            }
            while (!dq.isEmpty()) {
                final int[] curr = dq.removeFirst();
                final int r = curr[0];
                final int c = curr[1];
                for (int[] dir : DIRS) {
                    final int nr = r + dir[0];
                    final int nc = c + dir[1];
                    if (0 <= nr && nr < n && 0 <= nc && nc < m && d[nr][nc] > d[r][c] + 1) {
                        d[nr][nc] = d[r][c] + 1;
                        dq.offerLast(new int[] { nr, nc });
                    }
                }
            }
            int lo = 0;
            int hi = n + m;
            while (lo < hi) {
                final int mid = lo + hi >>> 1;
                if (!f(d, n, m, mid)) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            System.out.println("Case #" + x + ": " + lo);
        }
    }

    private static boolean f(int[][] d, int n, int m, int mid) {
        int maxL = (int) -1e9;
        int maxR = (int) -1e9;
        int minL = (int) 1e9;
        int minR = (int) 1e9;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (d[i][j] > mid) {
                    count++;
                    maxL = Math.max(maxL, i + j);
                    maxR = Math.max(maxR, i - j);
                    minL = Math.min(minL, i + j);
                    minR = Math.min(minR, i - j);
                }
            }
        }
        if (count == 0) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curr = 0;
                curr = Math.max(curr, Math.abs(maxL - (i + j)));
                curr = Math.max(curr, Math.abs(minL - (i + j)));
                curr = Math.max(curr, Math.abs(maxR - (i - j)));
                curr = Math.max(curr, Math.abs(minR - (i - j)));
                if (curr <= mid) {
                    return true;
                }
            }
        }
        return false;
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
