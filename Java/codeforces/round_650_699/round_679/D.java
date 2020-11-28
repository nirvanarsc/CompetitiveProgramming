package codeforces.round_650_699.round_679;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    static class MinStack {

        Deque<Integer> stack;
        Deque<Integer> min;

        MinStack() {
            stack = new ArrayDeque<>();
            min = new ArrayDeque<>();
        }

        public void push(int x) {
            if (min.isEmpty() || min.peekFirst() >= x) {
                min.addFirst(x);
            }
            stack.addFirst(x);
        }

        public int pop() {
            final Integer res = stack.removeFirst();
            if (min.element().equals(res)) {
                min.removeFirst();
            }
            return res;
        }

        public int top() {
            return stack.element();
        }

        public int getMin() {
            return min.isEmpty() ? (int) 1e9 : min.element();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final String[] events = new String[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            if ("+".equals(fs.next())) {
                events[i] = "+";
            } else {
                events[i] = fs.next();
            }
        }
        final Deque<Integer> res = new ArrayDeque<>();
        final MinStack dq = new MinStack();
        for (int i = 2 * n - 1; i >= 0; i--) {
            if (events[i].charAt(0) == '+') {
                if (dq.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                res.addFirst(dq.pop());
            } else {
                final int num = Integer.parseInt(events[i]);
                if (num > dq.getMin()) {
                    System.out.println("NO");
                    return;
                }
                dq.push(num);
            }
        }
        System.out.println("YES");
        while (!res.isEmpty()) {
            System.out.print(res.removeFirst() + " ");
        }
        System.out.println();
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
