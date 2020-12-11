package atcoder.beginner_100_199.beginner_123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int[] arr = new int[5];
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr[i] = fs.nextInt();
            indices.add(i);
        }
        int res = (int) 1e9;
        while (!indices.isEmpty()) {
            int curr = 0;
            for (int idx : indices) {
                if (curr % 10 != 0) {
                    curr = curr + 10 - curr % 10;
                }
                curr += arr[idx];
            }
            res = Math.min(res, curr);
            indices = nextPermutation(indices);
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
