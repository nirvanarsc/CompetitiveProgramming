package leetcode.weekly_contests.weekly_206;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P_1585 {

    public boolean isTransformable(String sX, String tX) {
        if (sX.length() != tX.length()) {
            return false;
        }
        final char[] sSorted = sX.toCharArray();
        final char[] tSorted = tX.toCharArray();
        Arrays.sort(sSorted);
        Arrays.sort(tSorted);
        if (!Arrays.equals(sSorted, tSorted)) {
            return false;
        }
        final int n = sX.length();
        final char[] s = sX.toCharArray();
        final char[] t = tX.toCharArray();
        final Map<Integer, Deque<Integer>> positions = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            positions.put(i, new ArrayDeque<>());
        }
        for (int i = 0; i < n; i++) {
            positions.get(t[i] - '0').addLast(i);
        }
        final int[] mapTo = new int[n];
        for (int i = 0; i < n; i++) {
            mapTo[i] = positions.get(s[i] - '0').removeFirst();
        }
        final int[] lBound = new int[10];
        for (int i = 0; i < n; i++) {
            final int val = s[i] - '0';
            final int to = mapTo[i];
            if (to < lBound[val]) {
                return false;
            }
            for (int j = val + 1; j < 10; j++) {
                lBound[j] = Math.max(lBound[j], to);
            }
        }
        return true;
    }
}
