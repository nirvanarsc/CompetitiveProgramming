package atcoder.beginner_100_199.beginner_177;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class E {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[] arr = fs.readArray(n);
        final int max = (int) 1e6;
        final boolean[] seen = new boolean[max + 1];
        boolean pairwiseCoprime = true;
        outer:
        for (int num : arr) {
            final int limit = num;
            for (int p = 2; p * p <= limit; p++) {
                if (num % p == 0) {
                    if (seen[p]) {
                        pairwiseCoprime = false;
                        break outer;
                    }
                    seen[p] = true;
                    while (num % p == 0) {
                        num /= p;
                    }
                }
            }
            if (num > 1) {
                if (seen[num]) {
                    pairwiseCoprime = false;
                    break;
                }
                seen[num] = true;
            }
        }
        if (pairwiseCoprime) {
            System.out.println("pairwise coprime");
            return;
        }
        int gcd = arr[0];
        for (int num : arr) {
            gcd = gcd(gcd, num);
        }
        System.out.println(gcd == 1 ? "setwise coprime" : "not coprime");
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
