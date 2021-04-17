package atcoder.beginner_like.jsc_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    static int[][] table;
    static int[][] basetable;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int k = fs.nextInt();
        final String s = fs.next();
        int temp = s.length();
        for (int i = 0; i < k; i++) {
            if (temp == 0) {
                System.out.println("impossible");
                return;
            }
            if (temp % 2 != 0) {
                temp--;
            }
            temp /= 2;
        }
        if (temp == 1) {
            System.out.println("impossible");
            return;
        }
        basetable = new int[temp][26];
        table = new int[k + 1][26];
        calc(s, k, false);
        int total = 0;
        for (int[] list : table) {
            int sum = 0;
            int max = 0;
            for (int i : list) {
                sum += i;
                max = Math.max(i, max);
            }
            total += sum - max;
        }
        final int[] max = new int[temp];
        final int[] max_idx = new int[temp];
        final int[] sec = new int[temp];
        for (int i = 0; i < temp; i++) {
            int sum = 0;
            for (int m = 0; m < 26; m++) {
                sum += basetable[i][m];
                if (basetable[i][m] >= max[i]) {
                    sec[i] = max[i];
                    max[i] = basetable[i][m];
                    max_idx[i] = m;
                } else if (basetable[i][m] >= sec[i]) {
                    sec[i] = basetable[i][m];
                }
            }
            total += sum - max[i];
        }
        boolean flag = temp >= 2;
        for (int n = 0; n < temp; n++) {
            if (max_idx[n] != max_idx[temp - n - 1] && (temp % 2 == 0 || n != temp / 2)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < temp; i++) {
                if ((temp % 2 == 0 || i != temp / 2) && min > max[i] - sec[i]) {
                    min = max[i] - sec[i];
                }
            }
            total += min;
        }
        System.out.println(total);
    }

    private static void calc(String str, int level, boolean rev) {
        if (level == 0) {
            if (rev) {
                for (int i = 0; i < str.length(); i++) {
                    basetable[str.length() - i - 1][str.charAt(i) - 'a']++;
                }
            } else {
                for (int i = 0; i < str.length(); i++) {
                    basetable[i][str.charAt(i) - 'a']++;
                }
            }
        } else {
            if (str.length() % 2 == 1) {
                table[level][str.charAt(str.length() / 2) - 'a']++;
            }
            calc(str.substring(0, str.length() / 2), level - 1, false);
            calc(str.substring(str.length() - str.length() / 2), level - 1, true);
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
