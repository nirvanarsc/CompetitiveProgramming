package atcoder.beginner_165;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public final class F {

    public static int upper_bound(long[] array, long key) {
        int lower = -1, upper = array.length;
        while (upper - lower > 1) {
            final int mid = (lower + upper) / 2;
            final int comp = Long.compare(array[mid], key);
            if (comp <= 0) {
                lower = mid;
            } else {
                upper = mid;
            }
        }
        return upper;
    }

    public static void dfs(int node, int parent, long[] vs, long[] lis, int lis_max,
                           List<List<Integer>> adj, int[] answer) {
        final int lis_index = upper_bound(lis, vs[node]);
        boolean updated = false;
        long updated_lis = 0;
        if (lis[lis_index] > vs[node] && lis[lis_index - 1] < vs[node]) {
            updated = true;
            updated_lis = lis[lis_index];
            lis[lis_index] = vs[node];
            lis_max = Math.max(lis_max, lis_index);
        }
        answer[node] = lis_max;
        for (int next : adj.get(node)) {
            if (next == parent) {
                continue;
            }
            dfs(next, node, vs, lis, lis_max, adj, answer);
        }
        if (updated) {
            lis[lis_index] = updated_lis;
        }
    }

    public static void main(String[] args) throws IOException {
        try (final Scanner sc = new Scanner(System.in)) {
            final int N = sc.nextInt();
            final List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                adj.add(new ArrayList<>());
            }
            final long[] as = new long[N];
            for (int i = 0; i < N; i++) {
                as[i] = sc.nextLong();
            }
            for (int i = 0; i < N - 1; i++) {
                final int u = sc.nextInt() - 1;
                final int v = sc.nextInt() - 1;
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            final long[] lis = new long[N + 1];
            Arrays.fill(lis, Long.MAX_VALUE);
            lis[0] = 0;
            final int[] answer = new int[N];
            dfs(0, -1, as, lis, 0, adj, answer);
            for (int i = 0; i < N; i++) {
                System.out.println(answer[i]);
            }
        }
    }

    public static class Scanner implements Closeable {
        private final BufferedReader br;
        private StringTokenizer tok;

        public Scanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        private void getLine() throws IOException {
            while (!hasNext()) {
                tok = new StringTokenizer(br.readLine());
            }
        }

        private boolean hasNext() {
            return tok != null && tok.hasMoreTokens();
        }

        public String next() throws IOException {
            getLine();
            return tok.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public int[] nextIntArray(int n) throws IOException {
            final int[] ret = new int[n];
            for (int i = 0; i < n; i++) {
                ret[i] = nextInt();
            }
            return ret;
        }

        public long[] nextLongArray(int n) throws IOException {
            final long[] ret = new long[n];
            for (int i = 0; i < n; i++) {
                ret[i] = nextLong();
            }
            return ret;
        }

        @Override
        public void close() throws IOException {
            br.close();
        }
    }
}
