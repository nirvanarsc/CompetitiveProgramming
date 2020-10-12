package codeforces.round_651;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final int k = in.nextInt();
        in.nextLine();
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.nextLine();
        System.out.println(dfs(arr, 0, -1, -1, k, 0, new HashMap<>()));
    }

    private static int dfs(int[] arr, int idx, int maxEven, int maxOdd, int k, int seqIdx,
                           Map<String, Integer> dp) {
        if (idx == arr.length) {
            return k == seqIdx ? Math.min(maxEven, maxOdd) : Integer.MAX_VALUE;
        }
        String key = idx + "," + seqIdx + "," + maxEven + "," + maxOdd;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        final int skip = dfs(arr, idx + 1, maxEven, maxOdd, k, seqIdx, dp);
        int add = Integer.MAX_VALUE;
        if (seqIdx < k) {
            if (seqIdx % 2 == 0) {
                add = dfs(arr, idx + 1, maxEven, Math.max(maxOdd, arr[idx]), k, seqIdx + 1, dp);
            } else {
                add = dfs(arr, idx + 1, Math.max(maxEven, arr[idx]), maxOdd, k, seqIdx + 1, dp);
            }
        }
        dp.put(key, Math.min(skip, add));
        return Math.min(skip, add);
    }
}
