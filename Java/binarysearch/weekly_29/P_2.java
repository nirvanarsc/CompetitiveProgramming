package binarysearch.weekly_29;

import java.util.HashMap;
import java.util.Map;

public class P_2 {

    public boolean solve(int[][] pieces, int[] target) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }
        for (int[] p : pieces) {
            boolean ok = true;
            for (int num : p) {
                ok &= map.containsKey(num);
            }
            if (ok) {
                int prev = -1;
                for (int num : p) {
                    if (prev == -1 || (1 + prev) == map.get(num)) {
                        prev = map.remove(num);
                    } else {
                        return false;
                    }
                }
            }
        }
        return map.isEmpty();
    }
}
