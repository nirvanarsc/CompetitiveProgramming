package atcoder.beginner_100_199.beginner_128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;

public final class E {

    private static class Event {
        int time;
        int idx;
        boolean start;
        boolean query;

        Event(int time, int idx, boolean start, boolean query) {
            this.time = time;
            this.idx = idx;
            this.start = start;
            this.query = query;
        }
    }

    public static void main(String[] args) {
        final PrintWriter pw = new PrintWriter(System.out);
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        final Event[] events = new Event[2 * n + q];
        for (int i = 0; i < n; i++) {
            final int s = fs.nextInt();
            final int t = fs.nextInt();
            final int x = fs.nextInt();
            events[2 * i] = new Event(s - x, x, true, false);
            events[2 * i + 1] = new Event(t - x, x, false, false);
        }
        for (int i = 2 * n; i < 2 * n + q; i++) {
            events[i] = new Event(fs.nextInt(), -1, false, true);
        }
        Arrays.sort(events, (a, b) -> {
            if (a.time == b.time) {
                return a.query == b.query ? Boolean.compare(a.start, b.start)
                                          : Boolean.compare(a.query, b.query);
            } else {
                return Integer.compare(a.time, b.time);
            }
        });
        final TreeSet<Integer> set = new TreeSet<>();
        for (Event event : events) {
            if (event.query) {
                if (set.isEmpty()) {
                    pw.println(-1);
                } else {
                    pw.println(set.first());
                }
            } else {
                if (event.start) {
                    set.add(event.idx);
                } else {
                    set.remove(event.idx);
                }
            }
        }
        pw.close();
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
