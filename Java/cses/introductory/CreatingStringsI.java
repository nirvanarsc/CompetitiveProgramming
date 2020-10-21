package cses.introductory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class CreatingStringsI {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final char[] chars = fs.next().toCharArray();
        Arrays.sort(chars);
        final List<String> permutations = new ArrayList<>();
        do {
            permutations.add(new String(chars));
        } while (nextPermutation(chars));
        System.out.println(permutations.size());
        for (String p : permutations) {
            System.out.println(p);
        }
    }

    public static boolean nextPermutation(char[] nums) {
        int idx = nums.length - 1, swapIdx = nums.length - 1;

        while (idx != 0 && nums[idx - 1] >= nums[idx]) {
            idx--;
        }

        if (idx == 0) {
            return false;
        }

        idx -= 1;
        while (nums[swapIdx] <= nums[idx]) {
            swapIdx--;
        }

        final char temp = nums[idx];
        nums[idx] = nums[swapIdx];
        nums[swapIdx] = temp;

        reverse(nums, idx + 1, nums.length - 1);
        return true;
    }

    private static void reverse(char[] nums, int from, int to) {
        while (from < to) {
            final char t = nums[from];
            nums[from] = nums[to];
            nums[to] = t;
            from++;
            to--;
        }
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
