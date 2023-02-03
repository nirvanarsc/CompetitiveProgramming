package leetcode.weekly_contests.weekly_300_399.weekly_330;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P_3 {

    public long putMarbles(int[] weights, int k) {
        final List<Integer> list = new ArrayList<>();
        final int n = weights.length;
        for (int i = 0; i < n - 1; i++) {
            list.add(weights[i] + weights[i + 1]);
        }
        list.sort(Comparator.naturalOrder());
        long a = 0;
        for (int i = 0; i < k - 1; i++) {
            a += list.get(i);
        }
        Collections.reverse(list);
        long b = 0;
        for (int i = 0; i < k - 1; i++) {
            b += list.get(i);
        }
        return b - a;
    }
}
