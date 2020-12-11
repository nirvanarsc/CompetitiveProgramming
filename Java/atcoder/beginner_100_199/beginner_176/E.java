package atcoder.beginner_100_199.beginner_176;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int mines = fs.nextInt();
        final int[] rows = new int[n + 1];
        final int[] cols = new int[m + 1];
        final Set<String> seen = new HashSet<>();
        int maxR = 0, rowIdx = -1;
        int maxC = 0, colIdx = -1;
        for (int i = 0; i < mines; i++) {
            final int x = fs.nextInt();
            final int y = fs.nextInt();
            if (++rows[x] > maxR) {
                maxR = rows[x];
                rowIdx = x;
            }
            if (++cols[y] > maxC) {
                maxC = cols[y];
                colIdx = y;
            }
            seen.add(x + "," + y);
        }
        int res = 0;
        for (int col = 1; col <= m; col++) {
            res = Math.max(res, maxR + cols[col] - (seen.contains(rowIdx + "," + col) ? 1 : 0));
        }
        for (int row = 1; row <= n; row++) {
            res = Math.max(res, maxC + rows[row] - (seen.contains(row + "," + colIdx) ? 1 : 0));
        }
        System.out.println(res);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
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

        int[] readArray(int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) { a[i] = nextInt(); }
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
