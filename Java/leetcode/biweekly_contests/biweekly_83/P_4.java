package leetcode.biweekly_contests.biweekly_83;

import java.util.HashMap;
import java.util.Map;

public class P_4 {

    public int shortestSequence(int[] rolls, int k) {
        int res = 1;
        final Map<Integer, Integer> f = new HashMap<>();
        for (int num : rolls) {
            f.merge(num, 1, Integer::sum);
            if (f.size() == k) {
                res++;
                f.clear();
            }
        }
        return res;
    }
}
