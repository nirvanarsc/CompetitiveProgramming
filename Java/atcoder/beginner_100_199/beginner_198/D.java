package atcoder.beginner_100_199.beginner_198;

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

public final class D {

    private static class CombinationIterator {
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

        @SuppressWarnings("ReturnOfNull")
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
        final char[] s1 = fs.next().toCharArray();
        final char[] s2 = fs.next().toCharArray();
        final char[] s3 = fs.next().toCharArray();
        int uniq = 0;
        for (char c : s1) {
            uniq |= 1 << (c - 'a');
        }
        for (char c : s2) {
            uniq |= 1 << (c - 'a');
        }
        for (char c : s3) {
            uniq |= 1 << (c - 'a');
        }
        final int bits = Integer.bitCount(uniq);
        if (bits > 10) {
            System.out.println("UNSOLVABLE");
            return;
        }
        final char[] map = new char[bits];
        int idx = 0;
        for (int i = 0; i < 26; i++) {
            if ((uniq & (1 << i)) != 0) {
                map[idx++] = (char) (i + 'a');
            }
        }
        final CombinationIterator ci = new CombinationIterator(10, bits);
        while (ci.hasNext()) {
            List<Integer> ll = Arrays.stream(ci.next()).sorted().boxed().collect(Collectors.toList());
            while (!ll.isEmpty()) {
                final int[] curr = new int[26];
                for (int i = 0; i < bits; i++) {
                    curr[map[i] - 'a'] = ll.get(i);
                }
                check(s1, s2, s3, curr);
                ll = nextPermutation(ll);
            }
        }
        System.out.println("UNSOLVABLE");
    }

    private static void check(char[] s1, char[] s2, char[] s3, int[] curr) {
        if (curr[s1[0] - 'a'] == 0 || curr[s2[0] - 'a'] == 0 || curr[s3[0] - 'a'] == 0) {
            return;
        }
        final char[] n1 = new char[s1.length];
        final char[] n2 = new char[s2.length];
        final char[] n3 = new char[s3.length];
        for (int i = 0; i < s1.length; i++) {
            n1[i] = (char) (curr[s1[i] - 'a'] + '0');
        }
        for (int i = 0; i < s2.length; i++) {
            n2[i] = (char) (curr[s2[i] - 'a'] + '0');
        }
        for (int i = 0; i < s3.length; i++) {
            n3[i] = (char) (curr[s3[i] - 'a'] + '0');
        }
        final long nn1 = Long.valueOf(new String(n1));
        final long nn2 = Long.valueOf(new String(n2));
        final long nn3 = Long.valueOf(new String(n3));
        if (nn1 + nn2 == nn3) {
            System.out.println(nn1);
            System.out.println(nn2);
            System.out.println(nn3);
            System.exit(0);
        }
    }

    private static List<Integer> nextPermutation(List<Integer> perm) {
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
