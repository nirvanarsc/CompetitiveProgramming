package hard;

import java.util.Map;
import java.util.TreeMap;

public class P_975 {

    public int oddEvenJumps(int[] A) {
        final int n = A.length;
        int res = 1;
        final boolean[] higher = new boolean[n];
        final boolean[] lower = new boolean[n];
        higher[n - 1] = lower[n - 1] = true;
        final TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n - 1], n - 1);
        for (int i = n - 2; i >= 0; --i) {
            final Map.Entry<Integer, Integer> hi = map.ceilingEntry(A[i]);
            final Map.Entry<Integer, Integer> lo = map.floorEntry(A[i]);
            if (hi != null) { higher[i] = lower[hi.getValue()]; }
            if (lo != null) { lower[i] = higher[lo.getValue()]; }
            if (higher[i]) { res++; }
            map.put(A[i], i);
        }
        return res;
    }

    public int oddEvenJumpsTopDown(int[] A) {
        int res = 0;
        final TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }
        final Boolean[][] dp = new Boolean[A.length][2];
        for (int i = 0; i < A.length; i++) {
            if (canJump(A, i, true, dp, map)) {
                res++;
            }
        }
        return res;
    }

    private static boolean canJump(int[] A, int i, boolean odd, Boolean[][] dp, TreeMap<Integer, Integer> map) {
        System.out.println(i);
        if (i == A.length - 1) {
            return true;
        }
        if (dp[i][odd ? 0 : 1] != null) {
            return dp[i][odd ? 0 : 1];
        }
        if (odd) {
            final Map.Entry<Integer, Integer> next = map.higherEntry(A[i]);
            return dp[i][0] = next == null ? false : canJump(A, next.getValue(), false, dp, map);
        } else {
            final Map.Entry<Integer, Integer> next = map.lowerEntry(A[i]);
            return dp[i][1] = next == null ? false : canJump(A, next.getValue(), true, dp, map);
        }
    }
}
