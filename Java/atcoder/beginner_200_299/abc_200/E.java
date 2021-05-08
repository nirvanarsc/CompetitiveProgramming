package atcoder.beginner_200_299.abc_200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        int[] f = new int[100];
        List<int[]> qq = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                for (int k = 1; k < 9; k++) {
                    qq.add(new int[] { i + j + k, i, j, k});
                }
            }
        }

        qq.sort((a,b) -> {
            if(a[0] == b[0]) {
                if(a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        System.out.println(Arrays.toString(f));

        for (int i = 0; i < qq.size(); i++) {
            System.out.println(i + " " + Arrays.toString(qq.get(i)));
        }

//
//        final int n = fs.nextInt();
//        final long k = fs.nextLong();
//
//        System.out.println(Arrays.toString(solve(n, k)));

    }

    private static int[] solve(int _n, long k) {
        long n = 1;
        long prev = -1;
        while (true) {
            long curr = (n * (n + 1) * (n + 2)) / 6;

            if (curr >= k || n == _n) {
                break;
            }
            prev = curr;
            n++;
        }
        long sum = n + 2;
        long loSum = ((n - 1) * n * (n + 1)) / 6;
        int l = 1;
        long maxMid = n;
        while (loSum + maxMid <= k) {
            loSum += maxMid;
            maxMid--;
            l++;
        }
        int diff = (int) (k - loSum);

        return new int[] { l, diff, (int) (sum - l - diff) };
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
