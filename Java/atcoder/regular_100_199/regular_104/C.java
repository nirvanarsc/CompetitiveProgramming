package atcoder.regular_100_199.regular_104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final Map<Integer, Integer> map = new HashMap<>();
        final Set<Integer> starts = new HashSet<>();
        final Set<Integer> ends = new HashSet<>();
        for (int i = 0; i < n; i++) {
            final int l = fs.nextInt();
            final int r = fs.nextInt();
            if (l != -1) {
                if (!starts.add(l)) {
                    System.out.println("No");
                    return;
                }
            }
            if (r != -1) {
                if (!ends.add(r)) {
                    System.out.println("No");
                    return;
                }
            }
            if (l != -1 && r != -1) {
                if (l >= r) {
                    System.out.println("No");
                    return;
                }
                map.put(l, r);
            }
        }
        for (int i = 1; i <= 2 * n; i++) {
            if (map.containsKey(i)) {
                final int r = map.get(i);
                for (int j = i + 1; j < r; j++) {
                    if (map.containsKey(j)) {
                        if (map.get(j) - j != r - i) {
                            System.out.println("No");
                            return;
                        }
                    } else {
                        if (starts.contains(j)) {
                            if (!ends.add(j + (r - i))) {
                                System.out.println("No");
                                return;
                            }
                        } else if (ends.contains(j + (r - i))) {
                            if (!starts.add(j)) {
                                System.out.println("No");
                                return;
                            }
                        } else {
                            starts.add(j);
                            if (!ends.add(j + (r - i))) {
                                System.out.println("No");
                                return;
                            }
                        }
                    }
                }
                i = r;
            }
        }
        System.out.println("Yes");
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
