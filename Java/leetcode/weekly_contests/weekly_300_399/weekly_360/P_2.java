package leetcode.weekly_contests.weekly_300_399.weekly_360;

import java.util.HashSet;
import java.util.Set;

public class P_2 {

    public long minimumPossibleSum(int n, int target) {
        final Set<Integer> set = new HashSet<>();
        long res = 0;
        int curr = 1;
        while (set.size() < n) {
            if (!set.contains(target - curr)) {
                set.add(curr);
                res += curr;
            }
            curr++;
        }
        return res;
    }
}
