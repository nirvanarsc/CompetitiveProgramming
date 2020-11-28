package codeforces.educational.educational_92;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final String[] line = in.nextLine().split(" ");
            final int n = Integer.parseInt(line[0]);
            final int k = Integer.parseInt(line[1]);
            final int z = Integer.parseInt(line[2]);
            final int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            in.nextLine();
            System.out.println(dfs(arr, 0, k + 1, z, 0, new Integer[n][z + 1][2]));
        }
    }

    private static int dfs(int[] arr, int idx, int k, int z, int left, Integer[][][] dp) {
        if (k == 0) {
            return 0;
        }
        if (idx >= 0 && dp[idx][z][left] != null) {
            return dp[idx][z][left];
        }
        int res = 0;
        if (idx > 0 && z > 0 && left == 0) {
            res = Math.max(res, arr[idx] + dfs(arr, idx - 1, k - 1, z - 1, 1, dp));
        }
        if (idx >= 0) {
            res = Math.max(res, arr[idx] + dfs(arr, idx + 1, k - 1, z, 0, dp));
        }
        if (idx >= 0) {
            dp[idx][z][left] = res;
        }
        return res;
    }
}
