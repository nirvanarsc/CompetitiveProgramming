package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public final class ClimbingTheLeaderboard {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[] ranked = fs.nextIntArray(n);
        final int m = fs.nextInt();
        final int[] player = fs.nextIntArray(m);
        final TreeMap<Integer, Integer> tm = new TreeMap<>();
        int idx = 1;
        final int min = ranked[n - 1];
        final int max = ranked[0];
        for (int i = 0; i < n; i++) {
            final Integer key = tm.get(ranked[i]);
            if (key == null) {
                tm.put(ranked[i], idx++);
            }
        }
        final StringBuilder sb = new StringBuilder();
        for (int p : player) {
            if (p < min) {
                sb.append(idx);
                sb.append('\n');
            } else if (p > max) {
                sb.append(1);
                sb.append('\n');
            } else {
                sb.append(tm.floorEntry(p).getValue());
                sb.append('\n');
            }
        }
        System.out.println(sb);
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
