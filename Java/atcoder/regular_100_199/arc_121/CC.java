package atcoder.regular_100_199.arc_121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class CC {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            final int n = fs.nextInt();
            List<Integer> ops = new ArrayList<>();
            final int[] arr = fs.nextIntArray(n);

            int[] sorted = arr.clone();
            Arrays.sort(sorted);
            int turn = 0;

            while (!Arrays.equals(arr, sorted)) {
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
                        boolean done = false;
                        for (int j = 0; j < n - 1; j++) {
                            if (j % 2 == 0 && arr[j] != (j + 1) && j + 1 != maxToMove) {
                                ops.add(j);
                                swap(arr, j, j + 1);
                                done = true;
                                break;
                            }
                        }
                        if (!done) {
                            ops.add(0);
                            swap(arr, turn, turn + 1);
                        }
                        turn ^= 1;
                    }
                    int tar = arr[maxToMove];
                    while (maxToMove != tar - 1) {
                        ops.add(maxToMove);
                        swap(arr, maxToMove, maxToMove + 1);
                        maxToMove++;
                        turn ^= 1;
                    }
                } else {
                    if (maxToMove % 2 == 0) {
                        boolean done = false;
                        for (int j = 0; j < n - 1; j++) {
                            if (j % 2 != 0 && arr[j] != (j + 1) && j + 1 != maxToMove) {
                                ops.add(j);
                                swap(arr, j, j + 1);
                                done = true;
                                break;
                            }
                        }
                        if (!done) {
                            ops.add(1);
                            swap(arr, turn, turn + 1);
                        }
                        turn ^= 1;
                    }
                    int tar = arr[maxToMove];
                    while (maxToMove != tar - 1) {
                        ops.add(maxToMove);
                        swap(arr, maxToMove, maxToMove + 1);
                        maxToMove++;
                        turn ^= 1;
                    }
                }
            }
            sb.append(ops.size());
            sb.append('\n');
            for (int op : ops) {
                sb.append(op + 1);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void swap(int[] arr, int l, int r) {
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
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
