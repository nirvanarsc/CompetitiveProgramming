package codeforces.educational_94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }
        System.out.println(dfs(arr, 0, n, new Integer[n][n + 1]));
    }

    private static int dfs(int[] arr, int idx, int depth, Integer[][] dp) {
        if (idx == arr.length - 1) {
            return 0;
        }
        if (dp[idx][depth] != null) {
            return dp[idx][depth];
        }
        int res;
        if (arr[depth] < arr[idx]) {
            //height increases
            res = 1 + dfs(arr, idx + 1, depth, dp);
            res = Math.min(res, arr[idx] - arr[depth] + dfs(arr, idx + 1, idx, dp));
        } else {
            res = dfs(arr, idx + 1, idx, dp);
        }
        return dp[idx][depth] = res;
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
