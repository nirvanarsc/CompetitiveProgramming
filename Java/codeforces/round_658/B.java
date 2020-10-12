package codeforces.round_658;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            in.nextLine();
            System.out.println(dfs(arr, 0, new Boolean[n]) ? "First" : "Second");
        }
    }

    private static boolean dfs(int[] arr, int idx, Boolean[] dp) {
        if (idx == arr.length) {
            return false;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }
        boolean res = false;
        final boolean next = !dfs(arr, idx + 1, dp);
        if (arr[idx] == 1) {
            res = next;
        } else {
            if (next) {
                res = true;
            } else {
                final int t = arr[idx];
                arr[idx] = 1;
                if (!dfs(arr, idx, dp)) {
                    res = true;
                }
                arr[idx] = t;
            }
        }
        return dp[idx] = res;
    }
}
