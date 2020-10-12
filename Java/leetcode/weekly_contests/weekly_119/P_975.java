package leetcode.weekly_contests.weekly_119;

import java.util.Map;
import java.util.TreeMap;

public class P_975 {

    @SuppressWarnings("MethodParameterNamingConvention")
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
}
