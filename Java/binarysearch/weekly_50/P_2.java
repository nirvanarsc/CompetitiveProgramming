package binarysearch.weekly_50;

import java.util.HashMap;
import java.util.Map;

public class P_2 {

    public int solve(int[] a, int[] b) {
        final Map<Integer, Integer> f = new HashMap<>();
        for (int num : a) {
            f.merge(num, 1, Integer::sum);
        }
        for (int num : b) {
            f.merge(num, 1, Integer::sum);
        }
        for (int i = 0; i < a.length; i++) {
            if (f.get(a[i]) == 1 && i != (a.length - 1)) {
                return a[i];
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (f.get(b[i]) == 1 && i != (b.length - 1)) {
                return b[i];
            }
        }
        return -1;
    }
}
