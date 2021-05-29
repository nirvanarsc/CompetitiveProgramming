package atcoder.regular_100_199.arc_121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        for (int i = 0; i < 100; i++) {
            Random r = new Random();
            final int t = r.nextInt(1) + 5;
            List<Integer> l = IntStream.range(1, t + 1).boxed().collect(Collectors.toList());
            Collections.shuffle(l);
            System.out.println(i + " " + l);
            test(l.stream().mapToInt(Integer::intValue).toArray(), l.size(), new StringBuilder());
        }
        final StringBuilder sb = new StringBuilder();

        System.out.println(sb);
    }

    private static void swap(int[] init, int[] arr, int l, int r) {
        if (r == arr.length) {
            System.out.println(Arrays.toString(init) + " " + Arrays.toString(arr) + " " + l + " " + r);
        }
        final int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }

    private static void test(int[] arr, int n, StringBuilder sb) {
        int[] init = arr.clone();
        final List<Integer> ops = new ArrayList<>();
        final int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int turn = 0;
        outer:
        while (!Arrays.equals(arr, sorted)) {
            System.out.println(Arrays.toString(arr));
            int maxToMove = -1;
            for (int j = 0; j < n; j++) {
                if (arr[j] != (j + 1)) {
                    if (maxToMove == -1 || arr[maxToMove] < arr[j]) {
                        maxToMove = j;
                    }
                }
            }
            if (turn == 0) {
                if (maxToMove % 2 != 0) {
                    ops.add(maxToMove - 1);
                    swap(init, arr, maxToMove - 1, maxToMove);
                    turn ^= 1;
                    continue;
                }
                int tar = arr[maxToMove];
                while (maxToMove != tar - 1) {
                    ops.add(maxToMove);
                    swap(init, arr, maxToMove, maxToMove + 1);
                    maxToMove++;
                    turn ^= 1;
                }
            } else {
                if (maxToMove % 2 == 0) {
                    if (maxToMove == 0) {
                        ops.add(1);
                        swap(init, arr, 1, 2);
                        turn ^= 1;
                        continue;
                    } else {
                        ops.add(maxToMove - 1);
                        swap(init, arr, maxToMove - 1, maxToMove);
                        turn ^= 1;
                        maxToMove -= 1;
                    }
                }
                int tar = arr[maxToMove];
                while (maxToMove != tar - 1) {
                    ops.add(maxToMove);
                    swap(init, arr, maxToMove, maxToMove + 1);
                    maxToMove++;
                    turn ^= 1;
                }
            }
        }
//            sb.append(ops.size());
//            sb.append('\n');
//            for (int op : ops) {
//                sb.append((op + 1) % 2);
//                sb.append(' ');
//            }
//            sb.append('\n');
//        System.out.println(ops);
        for (int i = 0; i < ops.size() - 1; i++) {
            if (ops.get(i) % 2 == ops.get(i + 1) % 2) {
                System.out.println(Arrays.toString(init));
                throw new IllegalArgumentException();
            }
        }
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
