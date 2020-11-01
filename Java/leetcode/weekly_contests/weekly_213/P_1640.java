package leetcode.weekly_contests.weekly_213;

import java.util.HashMap;
import java.util.Map;

public class P_1640 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        final Map<Integer, Integer> firsts = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            firsts.put(pieces[i][0], i);
        }
        int idx = 0;
        while (idx < arr.length) {
            if (!firsts.containsKey(arr[idx])) {
                return false;
            }
            final int[] next = pieces[firsts.get(arr[idx])];
            for (int num : next) {
                if (idx == arr.length) {
                    return false;
                }
                if (arr[idx] != num) {
                    return false;
                }
                idx++;
            }
        }
        return true;
    }
}
