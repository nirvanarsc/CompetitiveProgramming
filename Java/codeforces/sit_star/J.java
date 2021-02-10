package codeforces.sit_star;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class J {

    static class CombinationIterator {
        int n;
        int k;
        int[] combination;

        CombinationIterator(int n, int k) {
            this.n = n;
            this.k = k;
            combination = IntStream.range(0, k).toArray();
        }

        @SuppressWarnings("ConstantConditions")
        public int[] next() {
            final int[] res = combination.clone();
            combination = nextCombination(combination, n, k);
            return res;
        }

        public boolean hasNext() {
            return combination != null;
        }

        private static int[] nextCombination(int[] curr, int n, int k) {
            if (curr[k - 1] < n - 1) {
                curr[k - 1]++;
                return curr;
            }
            int idx = k - 1;
            while (idx > 0 && curr[idx] == curr[idx - 1] + 1) {
                idx--;
            }
            if (idx == 0) {
                return null;
            }
            idx--;
            curr[idx]++;
            for (int i = idx + 1; i < k; i++) {
                curr[i] = curr[i - 1] + 1;
            }
            return curr;
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int m = fs.nextInt();
        final int n = fs.nextInt();
        final int[][] p = new int[n][2];
        for (int i = 0; i < n; i++) {
            p[i] = new int[] { fs.nextInt(), fs.nextInt() };
        }
        int res = (int) 1e9;
        for (int i = 1; i <= Math.min(m, n); i++) {
            final CombinationIterator ci = new CombinationIterator(n, i);
            while (ci.hasNext()) {
                List<Integer> curr = Arrays.stream(ci.next()).boxed().collect(Collectors.toList());
                while (!curr.isEmpty()) {
                    final int[] cooldown = new int[curr.size()];
                    int time = 1;
                    int balloons = 0;
                    for (int j = 0; true; j++, time++) {
                        final int[] person = p[curr.get(j % curr.size())];
                        if (j >= curr.size()) {
                            time += Math.max(0, cooldown[j % curr.size()] - time);
                        }
                        cooldown[j % curr.size()] = time + person[1] - 1;
                        balloons += person[0];
                        if (balloons >= m) {
                            res = Math.min(res, time + 1);
                            break;
                        }
                    }
                    curr = nextPermutation(curr);
                }
            }
        }
        System.out.println(res);
    }

    public static List<Integer> nextPermutation(List<Integer> perm) {
        int swapIdx = -1;
        final int n = perm.size();
        for (int i = n - 1; i >= 1; i--) {
            if (perm.get(i - 1) < perm.get(i)) {
                swapIdx = i - 1;
                break;
            }
        }
        if (swapIdx == -1) {
            return Collections.emptyList();
        }
        for (int i = n - 1; i >= 1; i--) {
            if (perm.get(i) > perm.get(swapIdx)) {
                Collections.swap(perm, swapIdx, i);
                break;
            }
        }
        Collections.reverse(perm.subList(swapIdx + 1, perm.size()));
        return perm;
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
