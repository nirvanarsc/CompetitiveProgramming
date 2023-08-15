package leetcode.weekly_contests.weekly_300_399.weekly_355;

import java.util.Collections;
import java.util.List;

public class P_3 {

    public int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits);
        long sum = 0;
        int res = 0;
        final int n = usageLimits.size();
        for (int i = 0; i < n; i++) {
            sum += usageLimits.get(i);
            if (sum >= (res + 1) * (res + 2) / 2) {
                res++;
            }
        }
        return res;
    }
}
