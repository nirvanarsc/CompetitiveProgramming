package codeforces.educational.educational_94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int x = 0; x < t; x++) {
            final char[] s = fs.next().toCharArray();
            final int m = fs.nextInt();
            final int n = s.length;
            final char[] ans = new char[n];
            Arrays.fill(ans, '1');
            for (int i = 0; i < n; i++) {
                if (s[i] == '0') {
                    if (legal(i - m, n)) { ans[i - m] = '0'; }
                    if (legal(i + m, n)) { ans[i + m] = '0'; }
                }
            }
            boolean works = true;
            for (int i = 0; i < n; i++) {
                if (s[i] == '1') {
                    if (legal(i - m, n) && ans[i - m] == '1') { continue; }
                    if (legal(i + m, n) && ans[i + m] == '1') { continue; }
                    works = false;
                }
            }
            if (!works) {
                System.out.println(-1);
            } else {
                System.out.println(ans);
            }
        }
    }

    static boolean legal(int x, int n) {
        return x >= 0 && x < n;
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
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

        int[] readArray(int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) { a[i] = nextInt(); }
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
